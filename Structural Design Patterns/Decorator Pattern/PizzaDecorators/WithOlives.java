package PizzaDecorators;
import PizzaDecorator.*;
import PizzaInterface.*;

public class WithOlives extends PizzaDecorator{
    public WithOlives(Pizza pizza){
        super(pizza);
    }

    @Override
    public String getDescription(){
        return pizza.getDescription() + ", with Olives";
    }

    @Override
    public double getCost(){
        return pizza.getCost() + 27.00;
    }
}
