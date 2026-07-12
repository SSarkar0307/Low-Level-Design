public class StripeAPI{
    public void makePayment(double paymentAmount, String invoiceId){
        System.out.println("Paid " + paymentAmount + " with Invoice ID: " + invoiceId + " through Stripe");
    }
}
