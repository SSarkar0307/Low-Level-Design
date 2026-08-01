package OrderStates;

import OrderContext.*;
import OrderState.*;

public class OrderOutForDelivery implements OrderState{
    @Override
    public String getState(){
        return "ORDER_OUT_FOR_DELIVERY";
    }
    @Override
    public void next(OrderContext orderContext){
        orderContext.setContext(new OrderDelivered());
        System.out.println("Order is Delivered.");
    }    
    @Override
    public void cancelOrder(OrderContext orderContext){
        System.out.println("Order cannot be Cancelled now, already out for Delivery.");
    }
}
