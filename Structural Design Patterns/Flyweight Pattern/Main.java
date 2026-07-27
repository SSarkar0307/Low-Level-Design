public class Main {
    public static void main(String[] args) {
        Forest forest = new Forest();
        for(int i=1; i<10; i++){
            forest.plantTree(i, i, "Green", "Rough");
        }

        forest.draw();
    }
}
