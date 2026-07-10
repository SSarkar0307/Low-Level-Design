package factory;

import invoice.*;
import payment.*;

public class IndiaFactory implements RegionFactory{

    @Override
    public PaymentGateway createPaymentGateway(String gatewayType){
        if(gatewayType.equalsIgnoreCase("razorpay")) return new RazorpayGateway();

        else if(gatewayType.equalsIgnoreCase("payu")) return new PayUGateway();

        throw new IllegalArgumentException("Unsupported gateway for India");
    }

    @Override
    public Invoice createInvoice(){
        return new GSTInvoice();
    }
}