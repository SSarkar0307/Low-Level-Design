package Visitors;

import ItemVisitor.*;
import Items.*;

public class InvoiceVisitor implements ItemVisitor {
    public void visit(PhysicalProduct item) {
        System.out.println("Invoice: " + item.name + " - Shipping to customer");
    }

    public void visit(DigitalProduct item) {
        System.out.println("Invoice: " + item.name + " - Email with download link");
    }

    public void visit(GiftCard item) {
        System.out.println("Invoice: Gift Card - Code: " + item.code);
    }
}
