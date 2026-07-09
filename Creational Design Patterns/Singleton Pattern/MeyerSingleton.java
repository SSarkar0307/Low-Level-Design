public class MeyerSingleton implements Singleton{
    private MeyerSingleton() {}
    private static class Holder {
        private static final MeyerSingleton instance = new MeyerSingleton();
    }

    public static MeyerSingleton getInstance() {
        return Holder.instance;
    }

    @Override
    public void print(){
        System.out.println(Holder.instance);
    }
}
