package BasePizza;
import PizzaInterface.*;

public class RegularPizza implements Pizza{
    @Override
    public String getDescription(){
        return "Regular Pizza";
    }
        
    @Override
    public double getCost(){
        return 100;
    }
}
