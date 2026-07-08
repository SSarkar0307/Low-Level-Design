public class LazySyncSingleton implements Singleton {
    private LazySyncSingleton(){}
    private static LazySyncSingleton instance;

    public static synchronized LazySyncSingleton getInstance() {
        if(instance == null) instance = new LazySyncSingleton();
        return instance;
    }

    @Override
    public void print() {
        System.out.println("Lazy Sync" + instance);
    }
}