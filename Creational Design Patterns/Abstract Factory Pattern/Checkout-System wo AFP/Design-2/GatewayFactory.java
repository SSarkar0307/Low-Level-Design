public class GatewayFactory{
    public static PaymentGateway createPaymentGateway(String gatewayType) {
        if (gatewayType.equalsIgnoreCase("paypal")) {
            return new PayPalGateway();
        }
        else if (gatewayType.equalsIgnoreCase("stripe")) {
            return new StripeGateway();
        }
        else if (gatewayType.equalsIgnoreCase("razorpay")) {
            return new RazorpayGateway();
        } 
        else if (gatewayType.equalsIgnoreCase("payu")) {
            return new PayUGateway();
        }
        throw new IllegalArgumentException("Unsupported gateway : " + gatewayType);
    }
}