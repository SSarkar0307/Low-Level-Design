import java.util.*;
import java.util.concurrent.atomic.*;

class CounterWithoutThreadSafety{
    private int count=0;

    public void increament(){
        count++;
    }
    public int getCount(){
        return count;
    }
}

class CounterWithSynchronizedMethod{
    private int count=0;

    public synchronized void increament(){
        count++;
    }
    public synchronized int getCount(){
        return count;
    }
}

class CounterWithSynchronizedBlock{
    private int count=0;

    public void increament(){
        // Other code ...
        synchronized(this){ // Synchronized Block
            count++;
        }
        // Other code ...
    }
    public synchronized int getCount(){
        return count;
    }
}

// Still Thread-Safety not achieved, only improves data consistency
class CounterWithVolatileData{
    private volatile int count=0;

    public void increament(){
        count++;
    }
    public int getCount(){
        return count;
    }
}

class CounterWithAtomicData{
    AtomicInteger count = new AtomicInteger(0);
    
    public void increament(){
        int curr, next;
        do{
            curr = count.get();
            next = curr+1;
        }
        while(!count.compareAndSet(curr, next));
    }
    public int getCount(){
        return count.get();
    }
}

public class RaceCondition {
    public static void main(String[] args) {
        
        CounterWithVolatileData counter= new CounterWithVolatileData();
        
        Runnable task = () ->{
            for(int i=0; i<1000; i++){
                counter.increament();    
            }
        };

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
            taskThreads.add(new Thread(task));
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


