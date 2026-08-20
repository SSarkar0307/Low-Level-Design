import java.util.ArrayList;
import java.util.List;

class BankAccount{
    int id;
    private String name;
    private double balance;

    public BankAccount(int id, String name, double balance){
        this.id= id;
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
        List<BankAccount> lockOrder = new ArrayList<>(List.of(sender, receiver));
        lockOrder.sort((a, b) -> Integer.compare(a.id, b.id));

        BankAccount firstLock = lockOrder.get(0), secondLock = lockOrder.get(1);
        synchronized(firstLock){
            System.out.println("Lock held on " + firstLock.getName() + " By: " + Thread.currentThread().getName());
            
            synchronized(secondLock){
                System.out.println("Lock held on " + secondLock.getName() + " By: " + Thread.currentThread().getName());
                
                sender.withdraw(amount);
                receiver.deposit(amount);
                
                System.out.println("Transferred Rs. "+ amount + " from " + sender.getName() + " to " + receiver.getName());
            }
        }
    }
}


public class LockOrdering{
    public static void main(String[] args) {

        BankAccount accAlice = new BankAccount(001, "Alice", 1500.0);   
        BankAccount accBob = new BankAccount(002, "Bob", 3400.0);   


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