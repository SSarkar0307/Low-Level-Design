public class StripeAdapter implements PaymentGateway{
    private StripeAPI stripe;
    StripeAdapter(){
        this.stripe = new StripeAPI();
    }
    @Override
    public void pay(String OrderId, double amount){
        stripe.makePayment(amount, OrderId);
    }
}
