class GSTInvoice implements RegionInvoice{
    @Override
    public void generateInvoice(){
        System.out.println("Generating GST Invoice for India.");
    }
}

class USInvoice implements RegionInvoice{
    @Override
    public void generateInvoice(){
        System.out.println("Generating Invoice for US.");
    }
}