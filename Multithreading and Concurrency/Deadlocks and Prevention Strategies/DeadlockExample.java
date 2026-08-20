class BankAccount{
    private String name;
    private double balance;

    public BankAccount(String name, double balance){
        this.name= name;
        this.balance= balance;
    }
    public String getName(){
        return name;
    }
    public double getBalance(){
        return balance;
    }

    public synchronized void withdraw(double amt){
        if(amt<=balance) balance-= amt;
        System.out.println("Rs. " + amt + " withdrawn from: " + name);
        System.out.println("Current Balance is Rs. " + balance);
    }

    public synchronized void deposit(double amt){
        balance+= amt;
        System.out.println("Rs. " + amt + " deposited to: " + name);
        System.out.println("Current Balance is Rs. " + balance);
    }
}

class TransferTask implements Runnable{
    private final BankAccount sender, receiver;
    private final double amount;
    public TransferTask(BankAccount sender, BankAccount receiver, double amt){
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amt;
    }

    @Override
    public void run(){
        synchronized(sender){
            System.out.println("Lock held on " + sender.getName() + " By: " + Thread.currentThread().getName());
            
            synchronized(receiver){
                System.out.println("Lock held on " + receiver.getName() + " By: " + Thread.currentThread().getName());
                
                sender.withdraw(amount);
                receiver.deposit(amount);
                
                System.out.println("Transferred Rs. "+ amount + " from " + sender.getName() + " to " + receiver.getName());
            }
        }
    }
}


public class DeadlockExample{
    public static void main(String[] args) {

        BankAccount accAlice = new BankAccount("Alice", 1500.0);   
        BankAccount accBob = new BankAccount("Bob", 3400.0);   


        Thread t1 = new Thread(new TransferTask(accAlice, accBob, 450), "T1");
        Thread t2 = new Thread(new TransferTask(accBob, accAlice, 250), "T2");

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }
        catch(InterruptedException ignored){}
    }
}