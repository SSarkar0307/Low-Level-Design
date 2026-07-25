package PizzaDecorator;
import PizzaInterface.*;

abstract public class PizzaDecorator implements Pizza{
    protected Pizza pizza;
    protected PizzaDecorator(Pizza pizza){
        this.pizza= pizza;
    }
}
