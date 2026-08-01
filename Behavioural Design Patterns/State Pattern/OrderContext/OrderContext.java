package OrderContext;
import OrderState.*;
import OrderStates.*;

public class OrderContext {
    private OrderState orderState;

    public OrderContext(){
        this.orderState = new OrderPlaced();
    }

    public String getState(){
        return orderState.getState();
    }

    public void setContext(OrderState orderState){
        this.orderState = orderState;
    }

    public void next(){
        orderState.next(this);
    }

    public void cancel(){
        orderState.cancelOrder(this);
    }
}
