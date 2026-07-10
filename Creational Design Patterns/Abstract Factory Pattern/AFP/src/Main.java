import factory.*;
import service.*;

public class Main{
    public static void main(String[] args){
        CheckoutService service = new CheckoutService(new IndiaFactory(),"razorpay");
        service.completeOrder(1999);
    }
}