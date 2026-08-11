import java.util.concurrent.*;

public class CompletableFutureMethod{
    private static final ExecutorService executor = Executors.newFixedThreadPool(10);

    public static void sendEmail(String recipient) {

        CompletableFuture
        .supplyAsync(() -> {
            System.out.println("Sending Email to " + recipient + " on : " + Thread.currentThread().getName());

            try{
                Thread.sleep(2000);
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Email sent to " + recipient;
        }, executor)

        .thenAccept(message -> {
            System.out.println("CALLBACK: " + message + " on : " + Thread.currentThread().getName());
        }); 
    }
    
    public static void main(String[] args) {
        for(int i=1; i<=25; i++) {
            sendEmail("user" + i + "@gmail.com");
        }
        executor.shutdown(); 
    }
}