import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class TaskWithReentrantLock{
    private final ReentrantLock lock = new ReentrantLock();

    void runTask(String user){
        System.out.println(user + "-> Starting the task...");
        try{
            boolean acquired =lock.tryLock(2, TimeUnit.SECONDS);
            // boolean acquired =lock.tryLock();
            if(!acquired){
                System.out.println(user + "-> Failed to Perform task, Lock held by Another Thread.");
                return;
            }
    
            try{
                System.out.println(user + "-> Performing Task, Lock Acquired...");
                // task logic
            } catch(Exception e){
                e.printStackTrace();
            } finally{
                System.out.println(user + "-> Lock released...");
                lock.unlock();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}


// Auto Releases Idle Threads
class TaskWithReentrantLockWithWait{
    private final ReentrantLock lock = new ReentrantLock();

    void runTask(String user){
        System.out.println(user + "-> Starting the task...");
        lock.lock();

        try{
            System.out.println(user + "-> Performing Task, Lock Acquired...");
            // task logic
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            System.out.println(user + "-> Lock released...");
            lock.unlock();
        }

    }
}

// Doesnt much make sense for Idle Thread to Poll
class TaskWithReentrantLockWithExpirybyPolling {
    private final ReentrantLock lock = new ReentrantLock();
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    private volatile boolean expired;

    public boolean tryLockWithExpiry(long timeout){
        boolean acquired = lock.tryLock();

        if(acquired){
            expired = false;

            scheduler.schedule(()->{
                if(!expired){
                    expired = true;
                    System.out.println("Proceeding to Unlock Thread due to Idleness." + Thread.currentThread().getName());
                }
                }, timeout, TimeUnit.MILLISECONDS
            );

        }

        return acquired;
    }

    public void unlockSafely(){
        if(lock.isHeldByCurrentThread()){
            if(expired){
                System.out.println("Lock Released by " + Thread.currentThread().getName());
                lock.unlock();
                expired = false;
            }
        }
    }

    public boolean hasExpired() {
        return expired;
    }

}


class TaskWithReentrantLockWithExpirybyInterruption {
    private final ReentrantLock lock = new ReentrantLock();
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    private volatile boolean isLocked = false;

    public boolean tryLockWithExpiry(long timeout){
        boolean acquired = lock.tryLock();

        if(acquired){
            Thread owner = Thread.currentThread();
            System.out.println("Lock acquired by " + Thread.currentThread().getName());
            isLocked = true;

            scheduler.schedule(()->{
                if(isLocked){
                    System.out.println("Proceeding to Unlock Thread due to Idleness." + owner.getName());
                    owner.interrupt();
                }
            }, timeout, TimeUnit.MILLISECONDS);
        }
        return acquired;
    }
    

    public void closeExecutor(){
        scheduler.shutdownNow();
    }

    public void unlockSafely(){
        if(lock.isHeldByCurrentThread()){
            if(isLocked){
                System.out.println("Lock Released By " + Thread.currentThread().getName());
                lock.unlock();
                isLocked = false;
            }
        }
    }
}


public class Main{
    public static void main(String[] args) {

        // TaskWithReentrantLockWithWait task = new TaskWithReentrantLockWithWait();

        // Thread thread1 = new Thread(()-> task.runTask("user 1"));

        // Thread thread2 = new Thread(()-> task.runTask("user 2"));

        // thread1.start();
        // thread2.start();

        // try{
        //     thread1.join();
        //     thread2.join();
        // } catch(InterruptedException e){
        //     Thread.currentThread().interrupt();
        // }


        // If a Thread is idle, then it can't perform polling itself, some other threads needs to invoke or interrupt
        // Below code doesn't work...  

        // TaskWithReentrantLockWithExpiry expLock = new TaskWithReentrantLockWithExpiry();
        // Thread thread1= new Thread(()-> {
        //     if(expLock.tryLockWithExpiry(3000)){
        //         try{
        //             while(!expLock.hasExpired()){
        //                 // task logic
                        
        //                 Thread.sleep(5000); // Polling fails
        //             }
        //         }
        //         catch(Exception e){
        //             e.printStackTrace();
        //         }
        //         finally{
        //             expLock.unlockSafely();
        //         }
        //     }
        // });

        TaskWithReentrantLockWithExpirybyInterruption expLock = new TaskWithReentrantLockWithExpirybyInterruption();

        Thread thread1 = new Thread(()->{
            if(expLock.tryLockWithExpiry(3000)){
                try{
                    Thread.sleep(6000);
                    System.out.println("Thread Releasing Lock Normally " + Thread.currentThread().getName());

                }
                catch(InterruptedException e){
                    System.out.println("Thread Releasing Lock due to Idleness " + Thread.currentThread().getName());
                    Thread.currentThread().interrupt();
                }
                finally{
                    expLock.unlockSafely();
                }
            }
        });

        Thread thread2 = new Thread(()->{
            while(true){
                if(expLock.tryLockWithExpiry(3000)){
                    System.out.println("Second Task Performing By " + Thread.currentThread().getName());
                    expLock.unlockSafely();
                    break;
                }
                // Only for Timed Polling
                else{
                    System.out.println("Second Task Waiting for Unlock...");
                    try{
                        Thread.sleep(1000);
                    }
                    catch(Exception ignored){}
                }
            }
        });

        thread1.start();
        thread2.start();
        
        try{
            thread1.join();
            thread2.join();
            expLock.closeExecutor();
            System.out.println("Done");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    
    }
}