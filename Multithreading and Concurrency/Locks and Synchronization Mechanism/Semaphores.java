import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class PremiumSubscription{
    private final Semaphore maxDevices;
    public PremiumSubscription(int maxDevices){
        this.maxDevices = new Semaphore(maxDevices);
    }

    public boolean login(String IPAddress) throws InterruptedException{
        System.out.println(IPAddress + " trying to login...");
        
        if(maxDevices.tryAcquire(1, TimeUnit.SECONDS)){ // Timed Waiting, or can also use acquire() to wait until released 
            // login logic 
            System.out.println(IPAddress + " Successfully Logged In.");
            return true;
        }
        else{
            // logout logic 
            System.out.println(IPAddress + " Login Request Denied - Too Many Devices.");
            return false;
        }
    }
    
    public void logout(String IPAddress){
        System.out.println(IPAddress + " Logged Out.");
        maxDevices.release();
    }
}

// Advanced Synchronized Counter to Handle RaceCondition during Multi-Threaded Operations with Efficient Logic Logic for Waiting and Multiple Owners at a time unlike Reentrant Locks
public class Semaphores {
    public static void main(String[] args) {
        PremiumSubscription account = new PremiumSubscription(1);
        
        final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

        Thread t1 = new Thread(()-> {
            try{
                if(account.login("001abc")){
                        Thread.sleep(1500);
                        account.logout("001abc");
                    }
            } catch(InterruptedException ignored){}
        });
        Thread t2 = new Thread(()-> {
            try{   
                if(account.login("002def")) account.logout("002def");
            } catch(InterruptedException ignored) {}
        });

        t1.start();
        t2.start();  // Works only with Timed tryAcquire otherwise, 
        // scheduler.schedule(()-> t2.start(), 1600, TimeUnit.MILLISECONDS);
        
        try{
            t1.join();
            t2.join();
            scheduler.shutdown();
        }
        catch (InterruptedException ignored){}

    }
}
