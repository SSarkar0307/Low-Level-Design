public class Main {
    public static void main(String [] args){
        EagerSingleton.getInstance().print();
        Singleton instance1 = EagerSingleton.getInstance();  
        Singleton instance2 = LazySingleton.getInstance();  
        Singleton instance3 = LazySyncSingleton.getInstance();  
        Singleton instance4 = DoubleCheckedSingleton.getInstance(); 
    }
}
