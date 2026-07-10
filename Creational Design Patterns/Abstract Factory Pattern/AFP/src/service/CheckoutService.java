package service;

import factory.*;
import invoice.*;
import payment.*;

public class CheckoutService{
    private PaymentGateway paymentGateway;
    private Invoice invoice;

    public CheckoutService(RegionFactory factory, String gatewayType){
        paymentGateway = factory.createPaymentGateway(gatewayType);
        invoice = factory.createInvoice();
    }

    public void completeOrder(double amount){
        paymentGateway.processPayment(amount);
        invoice.generateInvoice();
    }
}