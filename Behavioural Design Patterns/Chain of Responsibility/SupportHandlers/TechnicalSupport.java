package SupportHandlers;

import SupportHandler.*;

public class TechnicalSupport extends SupportHandler{
    @Override
    public void handleRequest(String requestType){
        if(requestType.equalsIgnoreCase("Technical")){
            System.out.println("Handling Technical Support Request");
        } else if(nextHandler != null){
            nextHandler.handleRequest(requestType);
        } else{
            System.out.println("No Such Request Supported.");
        }
        
    }
}
