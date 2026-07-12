public class Razorpay implements PaymentGateway{
    @Override
    public void pay(String OrderId, double amount){
        System.out.println("Paid " + amount + " with Order ID: " + OrderId + " through Razorpay");
    }
}