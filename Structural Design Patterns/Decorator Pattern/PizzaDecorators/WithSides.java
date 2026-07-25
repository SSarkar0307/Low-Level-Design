package PizzaDecorators;
import PizzaDecorator.*;
import PizzaInterface.*;

public class WithSides extends PizzaDecorator{
    public WithSides(Pizza pizza){
        super(pizza);
    }

    @Override
    public String getDescription(){
        return pizza.getDescription() + ", with Sides";
    }

    @Override
    public double getCost(){
        return pizza.getCost() + 20.00;
    }
}
