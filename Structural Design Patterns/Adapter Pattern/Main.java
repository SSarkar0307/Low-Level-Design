public class Main{
    public static void main(String[] args) {
        CheckoutService checkout = new CheckoutService("stripe");
        checkout.pay("98asb", 1500);
    }
}