package VideoPlayer;
import VideoQualityInterface.*;

public class MobilePlayer extends VideoPlayer{
    public MobilePlayer(VideoQuality videoQuality){
        super(videoQuality);
    }    

    @Override
    public void playVideo(String url){
        videoQuality.loadVideo(url);
        System.out.println(url + " Started Playing in Mobile...");
    }
}
