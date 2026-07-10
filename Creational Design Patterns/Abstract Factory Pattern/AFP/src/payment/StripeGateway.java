package payment;

public class StripeGateway implements PaymentGateway{
    @Override
    public void processPayment(double amount){
        System.out.println("Processing USD payment via Stripe: " + amount);
    }
}
