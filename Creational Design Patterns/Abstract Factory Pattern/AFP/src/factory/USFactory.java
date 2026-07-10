package factory;

import invoice.*;
import payment.*;

public class USFactory implements RegionFactory{

    @Override
    public PaymentGateway createPaymentGateway(String gatewayType){
        if(gatewayType.equalsIgnoreCase("paypal")) return new PayPalGateway();

        if(gatewayType.equalsIgnoreCase("stripe")) return new StripeGateway();

        throw new IllegalArgumentException("Unsupported gateway for US");
    }

    @Override
    public Invoice createInvoice(){
        return new USInvoice();
    }
}