import java.util.*;

class CounterLogic{
    private int count=0;

    synchronized void increament(){
        count++;
    }
    synchronized int getCount(){
        return count;
    }
}

class Task implements Runnable{
    CounterLogic obj;
    int id;
    public Task(CounterLogic obj, int id){
        this.obj = obj;
        this.id = id;
    }

    public void run(){
        for(int i=0; i<1000; i++){
            try{

                obj.increament();
                // Thread.sleep(80);
                // System.out.println(obj.getCount() + " by Thread : " + this.id);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}


public class RaceCondition {
    public static void main(String[] args) {
        
        CounterLogic counter= new CounterLogic();
        
        // Runnable task = () ->{
        //     counter.increament();
        //     System.out.println(counter.getCount() + " by Thread : ");    
        // };

        // Task task= new Task(counter);
        // Thread taskThread = new Thread(task);
        // taskThread.start();


        // new Thread(new Task(counter)).start();
        // new Thread(new Task(counter)).start();
        

        // Individual Thread-Task creation and start
        // Thread t1 = new Thread(new Task(counter, 1));
        // t1.start();
        // Thread t2 = new Thread(new Task(counter, 2));
        // t2.start();

        List<Thread> taskThreads = new ArrayList<>();

        for(int i=0; i<10; i++){
            taskThreads.add(new Thread(new Task(counter, i)));
        }

        for(int i=0; i<10; i++){
            taskThreads.get(i).start();
        }

        try{
            for(int i=0; i<10; i++){
                taskThreads.get(i).join();
            }
            System.out.println(counter.getCount());
        }
        catch(Exception e){
            Thread.currentThread().interrupt();
        }
    }
}


