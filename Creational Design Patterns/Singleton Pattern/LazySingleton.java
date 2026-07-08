public class LazySingleton implements Singleton {
    private LazySingleton(){}
    private static LazySingleton instance;

    public static LazySingleton getInstance() {
        if(instance == null) instance = new LazySingleton();
        return instance;
    }

    @Override
    public void print() {
        System.out.println("Lazy" + instance);
    }
}