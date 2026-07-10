import java.util.*;
public class Builder{}

class Pizza{
    private final String baseType;
    private final String sauceType;

    private final boolean withExtraCheese;
    private final List<String> toppings;
    private final String drink;


    private Pizza(PizzaBuilder pizza){
        this.baseType = pizza.baseType;
        this.sauceType = pizza.sauceType;
        this.withExtraCheese = pizza.withExtraCheese;
        this.toppings = pizza.toppings;
        this.drink = pizza.drink;
    }

    public static class PizzaBuilder{
        private final String baseType;
        private final String sauceType;

        private boolean withExtraCheese;
        private List<String> toppings;
        private String drink;

        public PizzaBuilder(String baseType, String sauceType){
            this.baseType = baseType;
            this.sauceType = sauceType;
        }

        public PizzaBuilder addExtraCheese(boolean withExtraCheese){
            this.withExtraCheese = withExtraCheese;
            return this;
        }
        public PizzaBuilder addToppings(List<String> toppings){
            this.toppings = toppings;
            return this;
        }
        public PizzaBuilder addDrink(String drink){
            this.drink = drink;
            return this;
        }

        public Pizza build(){
            return new Pizza(this);
        }

    }

    public void getPizzaDetails(){
        System.out.println(baseType+"-"+sauceType+"-"+withExtraCheese+"-"+drink+"-"+toppings);
    } 
}