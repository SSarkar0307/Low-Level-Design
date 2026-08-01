package OrderStates;

import OrderContext.OrderContext;
import OrderState.*;

public class OrderCancelled implements OrderState{
    @Override
    public String getState(){
        return "ORDER_CANCELLED";
    }

    @Override
    public void next(OrderContext orderContext){
        System.out.println("Order Already Cancelled. Cannot proceed to next step.");    
    }    
    
    @Override
    public void cancelOrder(OrderContext orderContext){
        System.out.println("Order is Already Cancelled.");    
    }
}
