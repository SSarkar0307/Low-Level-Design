class CheckoutService{
    PaymentGateway gateway;
    CheckoutService(String gatewayType){
        this.gateway = GatewayDeterminer.getGateway(gatewayType);
    }
    public void pay(String OrderId, double amount){
        gateway.pay(OrderId, amount);
    }
}