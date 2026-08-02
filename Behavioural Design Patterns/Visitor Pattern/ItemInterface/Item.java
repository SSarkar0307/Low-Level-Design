package ItemInterface;
import ItemVisitor.*;

public interface Item{
    void accept(ItemVisitor visitor);
}