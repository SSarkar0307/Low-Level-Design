package Channels;
import ChannelInterface.*;
import java.util.*;
import SubscriberInterface.*;

public class YoutubeChannel implements Channel{
    String channelName;
    List<Subscriber> subscribers;
    public YoutubeChannel(String channelName){
        this.channelName = channelName;
        subscribers = new ArrayList<>();
    }
    @Override
    public void subscribe(Subscriber subscriber){
        subscribers.add(subscriber);    
    }
    @Override
    public void unsubscribe(Subscriber subscriber){
        subscribers.remove(subscriber);
    }
    @Override
    public void notifySubscribers(String videoTitle){
        for(Subscriber subscriber : subscribers){
            subscriber.sendNotification(videoTitle, channelName);
        }
    }

    public void uploadVideo(String videoTitle){
        notifySubscribers(videoTitle);
    }
}
