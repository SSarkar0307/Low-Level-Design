package PizzaDecorators;
// import BasePizza.*;
import PizzaInterface.*;
import PizzaDecorator.*;

public class WithCheese extends PizzaDecorator{
    public WithCheese(Pizza pizza){
        super(pizza);
    }
    @Override
    public String getDescription(){
        return pizza.getDescription() + ", with Extra Cheese ";
    }
    @Override
    public double getCost(){
        return pizza.getCost() + 19.00;
    }
}
