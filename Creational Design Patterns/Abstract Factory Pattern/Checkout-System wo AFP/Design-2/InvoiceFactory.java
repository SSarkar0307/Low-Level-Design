public class InvoiceFactory{
    public static RegionInvoice createInvoice(String region) {
        if(region.equalsIgnoreCase("India")){
            return new GSTInvoice();
        }
        else if(region.equalsIgnoreCase("US")){
            return new USInvoice();
        }
        throw new IllegalArgumentException("No Invoice for : " + region);
    }
}