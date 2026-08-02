public class Main{
    public static void main(String[] args) {
        Mediator doc = new CollaborativeDocument("Monthly Sales Report");

        User alice = new User("Alice", doc);
        User bob = new User("Bob", doc);
        User charlie = new User("Charlie", doc);

        doc.join(alice);
        doc.join(bob);
        doc.join(charlie);

        alice.makeChange("Added Logistics Expenditures");
        bob.makeChange("Customer Complaints and Support Updated.");
    }
}