class CheckoutService{
    private PaymentGateway paymentGateway;
    private RegionInvoice invoice;
    private RegionPolicy policy;
    

    public CheckoutService(String region, String gatewayType) {
        policy = RegionHelper.getRegionPolicy(region);
        if(!policy.supportsGateway(gatewayType)){
            throw new RuntimeException(gatewayType + " not available in: " + region);
        }
        paymentGateway = GatewayFactory.createPaymentGateway(gatewayType);
        invoice = InvoiceFactory.createInvoice(region);
    }

    public void completeOrder(double amount) {
        paymentGateway.processPayment(amount);
        invoice.generateInvoice();
    }
}