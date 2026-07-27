package VideoQualities;
import VideoQualityInterface.*;

public class SDPlayer implements VideoQuality{
    @Override
    public void loadVideo(String url){
        System.out.println("Loading Video in SD Quality...");
    }    
}
