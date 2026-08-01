package SupportHandlers;

import SupportHandler.*;

public class GeneralSupport extends SupportHandler{
    @Override
    public void handleRequest(String requestType){
        if(requestType.equalsIgnoreCase("General")){
            System.out.println("Handling General Support Request");
        } else if(nextHandler != null){
            nextHandler.handleRequest(requestType);
        }
        else{
            System.out.println("No Such Request Supported.");
        }
    }
}
