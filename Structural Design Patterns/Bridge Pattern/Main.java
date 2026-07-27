import VideoPlayer.*;
import VideoQualities.*;

public class Main{
    public static void main(String[] args){
        VideoPlayer mobile = new WebPlayer(new SDPlayer());
        mobile.playVideo("The Odyssey - 2026");
    }
}