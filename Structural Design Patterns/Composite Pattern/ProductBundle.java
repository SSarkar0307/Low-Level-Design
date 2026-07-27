import java.util.*;

public class ProductBundle implements CartItem{
    String bundleName;
    double bundlePrice;
    List<CartItem> bundle = new ArrayList<>();

    public ProductBundle(String bundleName){
        this.bundleName = bundleName;
        this.bundlePrice = 0.00;
    }

    public void addItemToBundle(CartItem item){
        bundle.add(item);
        this.bundlePrice += item.getPrice();
    }

    @Override
    public double getPrice(){
        return bundlePrice;
    }

    @Override
    public void displayDetails(){
        System.out.println(bundleName + "Bundle @ Rs." + bundlePrice);
        for(CartItem item : bundle){
            item.displayDetails();
        }
    } 

}