// India
class RazorpayGateway implements PaymentGateway{
    @Override
    public void processPayment(double amount){
        System.out.println("Processing INR payment via Razorpay: " + amount);
    }
}

class PayUGateway implements PaymentGateway{
    @Override
    public void processPayment(double amount){
        System.out.println("Processing INR payment via PayU: " + amount);
    }
}

// US
class PayPalGateway implements PaymentGateway{
    @Override
    public void processPayment(double amount){
        System.out.println("Processing USD payment via PayPal: " + amount);
    }
}

class StripeGateway implements PaymentGateway{
    @Override
    public void processPayment(double amount){
        System.out.println("Processing USD payment via Stripe: " + amount);
    }
}
