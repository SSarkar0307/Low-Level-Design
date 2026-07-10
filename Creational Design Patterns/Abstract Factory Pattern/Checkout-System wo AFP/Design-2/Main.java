class Main {
    public static void main(String[] args) {
        CheckoutService indiaCheckout = new CheckoutService("india", "razorpay");
        indiaCheckout.completeOrder(1999.0);
    }
}
