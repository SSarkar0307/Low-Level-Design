public class DoubleCheckedSingleton implements Singleton {
    private DoubleCheckedSingleton(){}
    private static volatile DoubleCheckedSingleton instance;

    public static DoubleCheckedSingleton getInstance() {
        if(instance == null){
            synchronized(DoubleCheckedSingleton.class) {
                if(instance == null){
                    instance = new DoubleCheckedSingleton();
                }
            }
        }
        return instance;
    }

    @Override
    public void print() {
        System.out.println("Double Check" + instance);
    }
}