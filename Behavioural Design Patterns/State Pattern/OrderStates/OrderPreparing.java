package OrderStates;

import OrderContext.*;
import OrderState.*;

public class OrderPreparing implements OrderState{
    @Override
    public String getState(){
        return "ORDER_PREPARING";
    }
    @Override
    public void next(OrderContext orderContext){
        orderContext.setContext(new OrderOutForDelivery());
        System.out.println("Order is out for Delivery.");
    }    
    @Override
    public void cancelOrder(OrderContext orderContext){
        orderContext.setContext(new OrderCancelled());
        System.out.println("Order has been Cancelled.");
    }
}
