public class Main{
    public static void main(String[] args){
    // Can work with void addOn functions in Builder
        // Pizza.PizzaBuilder builder = new Pizza.PizzaBuilder("Freshly Baked", "Italian");
        // builder.addDrink("Cola");
        // Pizza newPizza = builder.build();


    // This style to work, every addOn function needs to return the PizzaBuilder instance
        Pizza newPizza = new Pizza.PizzaBuilder("Freshly Baked", "Italian").addDrink("Coke").build();
        newPizza.getPizzaDetails();
    }
}