import java.util.*;
import ItemInterface.*;
import ItemVisitor.*;
import Items.*;
import Visitors.*;

public class Main{
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new PhysicalProduct("Shoes", 1.2));
        items.add(new DigitalProduct("Ebook", 100));
        items.add(new GiftCard("NEWYEAR2026", 599));

        ItemVisitor invoiceGenerator = new InvoiceVisitor();
        ItemVisitor shippingCalculator = new ShippingCostVisitor();

        for(Item item : items) {
            item.accept(invoiceGenerator);
            item.accept(shippingCalculator);
        }
    }
}