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

// Isn't responsible for Payment Method Handling, Orchestration the Payment Processing - SRP
class PaymentService{
    // void validatePayment();
    // void checkStock();

    public static void processPayment(String method){  // could be non-static if class needs to store any Object State(Data)
        PaymentGateway PaymentMethod = PaymentFactory.getPayment(method);
        PaymentMethod.pay();
    }
    // void sendNotification();
}