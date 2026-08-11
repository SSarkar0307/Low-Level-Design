import java.util.concurrent.*;

public class SubmitMethod{
    private static final ExecutorService executor = Executors.newFixedThreadPool(10);

    // Get method blocks the main thread (Breaks concurrency)
    public static void sendEmailWithReturnByGetMethod(String recipient) {
        
        Future<String> future = executor.submit(()-> {
            System.out.println("Sending Email to " + recipient + " on : " + Thread.currentThread().getName());
            
            Thread.sleep(3000);
            return "Email sent to " + recipient;
        });
        try{
            String message = future.get();
            System.out.println(message);
        }
        catch(InterruptedException | ExecutionException e){
            e.printStackTrace();
        }
        
    }
    
    // Get method Handled by a Separate Thread (Redundant)
    public static void sendEmailWithGetWithoutBlocking(String recipient) {
        
        Future<String> future = executor.submit(()-> {
            System.out.println("Sending Email to " + recipient + " on : " + Thread.currentThread().getName());

            Thread.sleep(3000);
            return "Email sent to " + recipient;
        });
        new Thread(()->{
            try{
                String message = future.get();
                System.out.println(message);
            }
            catch(InterruptedException | ExecutionException e){
                e.printStackTrace();
            }
        }).start();
        
    }

    // Replicating Callback style with Constant Polling
    public static void sendEmailWithReturnByConstantPolling(String recipient) {
        
        Future<String> future = executor.submit(()->{

            System.out.println("Sending Email to " + recipient + " on : " + Thread.currentThread().getName());

            Thread.sleep(3000);
            return "Email sent to " + recipient;
        });

        new Thread(() -> {
            try{
                while(!future.isDone()){
                    Thread.sleep(100); // Polling at every 100ms
                }
                System.out.println(future.get());
            }
            catch(InterruptedException  | ExecutionException e){
                Thread.currentThread().interrupt();
            }

        }).start();

        
    }

    // Removes the Return Type & Future so works in Non-Blocking manner
    public static void sendEmailWithNoReturn(String recipient) {
        executor.submit(()->{
            System.out.println("Sending Email to " + recipient + " on : " + Thread.currentThread().getName());

            try{
                Thread.sleep(3000);
            }
            catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
            System.out.println("Email sent to " + recipient);
        });
        
    }

    public static void main(String[] args) {
        for(int i=1; i<=25; i++) {
            // sendEmailWithReturnByGetMethod("user" + i + "@gmail.com");
            sendEmailWithGetWithoutBlocking("user" + i + "@gmail.com");
            // sendEmailWithReturnByConstantPolling("user" + i + "@gmail.com");
        }
        executor.shutdown(); 
    }
}