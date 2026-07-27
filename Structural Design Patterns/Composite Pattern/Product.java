public class Product implements CartItem{
    String name;
    double price;

    public Product(String name, double price){
        this.name= name;
        this.price= price;
    }

    @Override
    public double getPrice(){
        return price;
    }

    @Override
    public void displayDetails(){
        System.out.println(name + "- Rs." + price);
    } 

}