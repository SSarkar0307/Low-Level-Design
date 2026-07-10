package invoice;

public class USInvoice implements Invoice{

    @Override
    public void generateInvoice(){
        System.out.println("Generating Invoice as per US norms.");
    }
}