public interface PaymentGateway{
    public void pay();
}

class UPI implements PaymentGateway{
    @Override
    public void pay(){
        System.out.println("Paid via UPI");
    }
}

class Card implements PaymentGateway{
    @Override
    public void pay(){
        System.out.println("Paid via Card");
    }
}

class Wallet implements PaymentGateway{
    @Override
    public void pay(){
        System.out.println("Paid via Wallet");
    }
}

class PaymentFactory{
    public static PaymentGateway getPayment(String method){
        if(method.equalsIgnoreCase("UPI")) return new UPI();
        else if(method.equalsIgnoreCase("Card")) return new Card();
        else if(method.equalsIgnoreCase("Wallet")) return new Wallet();
        throw new IllegalArgumentException("Unknown Payment Method: " + method); 
    }
}

// Isn't responsible for Payment Method Handling, Orchestrates the Payment Processing - SRP
class PaymentService{

    public static void processPayment(String method){  // could be non-static if class needs to store any Object State(Data)

        // void validatePayment();
        // void checkStock();

        // PaymentGateway PaymentMethod = PaymentFactory.getPayment(method);
        // PaymentMethod.pay();
        PaymentFactory.getPayment(method).pay();

        // void updateDatabase();
        // void sendNotification();
    }
}