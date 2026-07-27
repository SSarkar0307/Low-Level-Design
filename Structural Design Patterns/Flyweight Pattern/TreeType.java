public class TreeType {
    String color;
    String texture;

    TreeType(String color, String texture){
        this.color = color;
        this.texture = texture;
    }

    void draw(int x, int y){
        System.out.println("Drawing tree of " + color + " color and " + texture +" texture on coordinates " + x + ", " + y);
    }
    

}
