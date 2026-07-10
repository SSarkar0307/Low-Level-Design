class Main {
    public static void main(String[] args) {
        // Using Razorpay in India
        CheckoutService indiaCheckout = new CheckoutService("india", "razorpay");
        indiaCheckout.completeOrder(1999.0);
    }
}
