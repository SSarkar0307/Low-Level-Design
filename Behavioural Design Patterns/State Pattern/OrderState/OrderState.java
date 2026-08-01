package OrderState;

import OrderContext.OrderContext;

public interface OrderState{
    String getState();
    void next(OrderContext orderContext);
    void cancelOrder(OrderContext orderContext);
}