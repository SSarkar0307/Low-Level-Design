package OrderStates;

import OrderContext.*;
import OrderState.*;

public class OrderDelivered implements OrderState{
    @Override
    public String getState(){
        return "ORDER_DELIVERED";
    }
    @Override
    public void next(OrderContext orderContext){
        System.out.println("Order already Delivered.");
    }    
    @Override
    public void cancelOrder(OrderContext orderContext){
        System.out.println("Delivered Order Cannot be Cancelled anymore.");
    }
}
