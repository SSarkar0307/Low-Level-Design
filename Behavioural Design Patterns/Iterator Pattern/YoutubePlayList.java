import java.util.*;

public class YoutubePlayList implements PlayList{
    List<Video> videos = new ArrayList<>();

    public void addVideo(Video video){
        this.videos.add(video);
    }
    
    @Override
    public PlayListIterator createIterator(){
        return new YoutubePlayListIterator(videos);       
    }
}
