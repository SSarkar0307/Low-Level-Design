import SupportHandler.*;
import SupportHandlers.*;

public class Main{
    public static void main(String[] args) {
        SupportHandler generalSupport = new GeneralSupport();
        SupportHandler technicalSupport = new TechnicalSupport();
        SupportHandler deliverySupport = new DeliverySupport();

        // Chain setup (declaration)
        generalSupport.setNextHandler(technicalSupport);
        technicalSupport.setNextHandler(deliverySupport);

        generalSupport.handleRequest("refund");
        generalSupport.handleRequest("delivery");
    }
}