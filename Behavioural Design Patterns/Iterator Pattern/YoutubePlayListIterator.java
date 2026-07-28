import java.util.*;

public class YoutubePlayListIterator implements PlayListIterator{
    List<Video> videos;
    int position;

    public YoutubePlayListIterator(List<Video> videos){
        this.videos = videos;
        this.position =0;
    }

    @Override
    public boolean hasNext(){
        return position < videos.size();
    }

    @Override
    public Video next(){
        return hasNext() ? videos.get(position++) : null; 
    }
}
