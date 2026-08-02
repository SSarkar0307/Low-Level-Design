package Items;

import ItemInterface.*;
import ItemVisitor.*;

public class DigitalProduct implements Item{
    public String name;
    int downloadSize;

    public DigitalProduct(String name, int downloadSize) {
        this.name = name;
        this.downloadSize = downloadSize;
    }

    public void accept(ItemVisitor visitor) {
        visitor.visit(this);
    }
}
