public class GatewayDeterminer {
    PaymentGateway paymentGateway;
    public static PaymentGateway getGateway(String gatewayType){
        if(gatewayType.equalsIgnoreCase("razorpay")){
            return new Razorpay();
        }
        else if(gatewayType.equalsIgnoreCase("stripe")){
            return new StripeAdapter();
        }
        throw new RuntimeException();
    }
}
