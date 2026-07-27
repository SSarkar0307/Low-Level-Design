import java.util.*;
public class Main{
    public static void main(String[] args) {
        CartItem phone = new Product("iPhone 15", 79999);
        CartItem charger = new Product("20W Charger", 1999);
        System.out.println("Individual Product Test");
        phone.displayDetails();
        
        ProductBundle iphoneCombo = new ProductBundle("iPhone Combo");
        iphoneCombo.addItemToBundle(phone);
        iphoneCombo.addItemToBundle(charger);
        
        ProductBundle gamingCombo = new ProductBundle("Gaming Combo");
        gamingCombo.addItemToBundle(new Product("HP Omen", 59999));
        gamingCombo.addItemToBundle(new Product("Razor Mouse", 7999));
        
        System.out.println("ProductBundle Test");
        iphoneCombo.displayDetails();
        
        List<CartItem> cart = new ArrayList<>();
        cart.add(phone);
        cart.add(gamingCombo);
        
        System.out.println("Cart Test");
        double cartTotal = 0.00;
        for(CartItem item : cart){
            item.displayDetails();
            cartTotal += item.getPrice();
        }
        System.out.println("Total Cart Price - Rs." + cartTotal);
    }
}