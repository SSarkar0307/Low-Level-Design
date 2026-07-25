package PizzaDecorators;
// import PizzaDecorator.*;
import PizzaInterface.*;
// Works without Decorator, but needs repititve implementation of Object Creation and Assignment.

public class WithSauce implements Pizza{
    Pizza pizza;
    public WithSauce(Pizza pizza){
        this.pizza = (pizza);
    }

    @Override
    public String getDescription(){
        return pizza.getDescription() + ", with Sauce";
    }

    @Override
    public double getCost(){
        return pizza.getCost() + 11.00;
    }
}
