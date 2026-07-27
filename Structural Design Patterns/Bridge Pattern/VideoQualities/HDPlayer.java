package VideoQualities;
import VideoQualityInterface.*;

public class HDPlayer implements VideoQuality{
    @Override
    public void loadVideo(String url){
        System.out.println("Loading Video in HD 1080P Quality...");
    }    
}
