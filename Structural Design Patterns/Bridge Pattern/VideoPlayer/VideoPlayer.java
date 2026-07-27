package VideoPlayer;
// import VideoQualities.*; 
import VideoQualityInterface.*; 

abstract public class VideoPlayer {
    protected VideoQuality videoQuality;

    VideoPlayer(VideoQuality videoQuality){
        this.videoQuality = videoQuality;
    }

    abstract public void playVideo(String url);

}
