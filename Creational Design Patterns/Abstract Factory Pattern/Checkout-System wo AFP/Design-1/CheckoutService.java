class CheckoutService{
    private PaymentGateway paymentGateway;
    private RegionInvoice invoice;

    public CheckoutService(String region, String gatewayType) {
        paymentGateway = GatewayFactory.createPaymentGateway(gatewayType);
        invoice = InvoiceFactory.createInvoice(region);
    }

    public void completeOrder(double amount) {
        paymentGateway.processPayment(amount);
        invoice.generateInvoice();
    }
}