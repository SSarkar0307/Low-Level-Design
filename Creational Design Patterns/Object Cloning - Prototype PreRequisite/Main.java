
import java.util.HashMap;


public class Main implements Cloneable{
    String name;
    HashMap<String, String> map;
    A objA;
    B objB;

    @Override
    public Main clone(){
        try{
            Main clonedMain = (Main) super.clone();

            if(this.map!= null){
                clonedMain.map = new HashMap<>(this.map);
            }
            if(this.objA!= null){
                clonedMain.objA = objA.clone();
            }
            if(this.objB!= null){
                clonedMain.objB = objB.clone();
            }

            return clonedMain;

        } 
        catch(CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

}

class ProgramRunner{
    public static void main(String[] args) {
        Main main = new Main();
    }
}
