package factory;

import invoice.*;
import payment.*;

public interface RegionFactory{
    PaymentGateway createPaymentGateway(String gatewayType);
    Invoice createInvoice();
}