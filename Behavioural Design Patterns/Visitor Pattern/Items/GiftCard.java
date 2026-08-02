package Items;
import ItemInterface.*;
import ItemVisitor.*;

public class GiftCard implements Item {
    public String code;
    double amount;

    public GiftCard(String code, double amount) {
        this.code = code;
        this.amount = amount;
    }

    public void accept(ItemVisitor visitor) {
        visitor.visit(this);
    }
}