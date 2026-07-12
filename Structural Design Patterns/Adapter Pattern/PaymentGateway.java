public interface PaymentGateway{
    void pay(String OrderId, double amount);
}