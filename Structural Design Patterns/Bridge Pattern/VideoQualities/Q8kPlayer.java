package VideoQualities;
import VideoQualityInterface.*;

public class Q8kPlayer implements VideoQuality{
    @Override
    public void loadVideo(String url){
        System.out.println("Loading Video in 8k Quality...");
    }    
}
