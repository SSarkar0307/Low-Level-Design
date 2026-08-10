class SMSTask implements Runnable{
    public void run(){
        try{
            Thread.sleep(2000);
            System.out.println("SMS sent using Thread for SMS.");
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

class EmailTask implements Runnable{
    public void run(){
        try{
            Thread.sleep(3000);
            System.out.println("Email sent using Thread for Email.");
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

class ETACalculationTask implements Runnable{
    public void run(){
        try{
            Thread.sleep(5000);
            System.out.println("ETA calculated using Thread for ETA. Estimated Time: 10 minutes");
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

public class Main{
    public static void main(String[] args) {
        SMSTask smsTask = new SMSTask();
        EmailTask emailTask = new EmailTask();
        ETACalculationTask etaTask = new ETACalculationTask();

        Thread smsThread = new Thread(smsTask);
        Thread emailThread = new Thread(emailTask);
        Thread etaThread = new Thread(etaTask);

        System.out.println("Tasks Have Started Running...");

        smsThread.start();
        System.out.println("Sending SMS...");
        
        emailThread.start();
        System.out.println("Sending Email...");

        etaThread.start();
        System.out.println("Calculating ETA...");


        try{
            smsThread.join();
            emailThread.join();
            etaThread.join();
            System.out.println("All Tasks Done.");
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}