package SupportHandlers;

import SupportHandler.*;

public class DeliverySupport extends SupportHandler{
    @Override
    public void handleRequest(String requestType){
        if(requestType.equalsIgnoreCase("Delivery")){
            System.out.println("Handling Delivery Support Request");
        } else if(nextHandler != null){
            nextHandler.handleRequest(requestType);
        } else{
            System.out.println("No Such Request Supported.");
        }
    }
}
