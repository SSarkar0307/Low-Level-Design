package VideoPlayer;
import VideoQualityInterface.*;

public class WebPlayer extends VideoPlayer{
    public WebPlayer(VideoQuality videoQuality){
        super(videoQuality);
    }    

    @Override
    public void playVideo(String url){
        videoQuality.loadVideo(url);
        System.out.println(url + " Started Playing on Web...");
    }
}
