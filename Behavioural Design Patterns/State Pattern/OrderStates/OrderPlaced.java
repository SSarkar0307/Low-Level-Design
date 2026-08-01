package OrderStates;

import OrderContext.*;
import OrderState.*;

public class OrderPlaced implements OrderState{
    @Override
    public String getState(){
        return "ORDER_PLACED";
    }
    @Override
    public void next(OrderContext orderContext){
        orderContext.setContext(new OrderPreparing());
        System.out.println("Order is being Prepared.");
    }    
    @Override
    public void cancelOrder(OrderContext orderContext){
        orderContext.setContext(new OrderCancelled());
        System.out.println("Order has been Cancelled.");
    }
}
