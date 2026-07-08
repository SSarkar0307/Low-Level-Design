public class EagerSingleton implements Singleton{
    private EagerSingleton(){}
    private static final EagerSingleton instance = new EagerSingleton();

    public static EagerSingleton getInstance() {
        return instance;
    }

    @Override
    public void print() {
        System.out.println("Eager" + instance);
    }
}