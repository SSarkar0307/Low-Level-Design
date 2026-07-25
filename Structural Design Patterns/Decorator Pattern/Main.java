import BasePizza.*;
// import PizzaDecorator.*;
import PizzaDecorators.*;
import PizzaInterface.*;
public class Main {
    public static void main(String[] args) {
        Pizza mypizza = new WithSauce(new WithCheese(new RegularPizza()));

        System.out.println(mypizza.getDescription());
    }
}
