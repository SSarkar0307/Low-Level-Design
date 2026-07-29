package Subscribers;

import SubscriberInterface.*;

public class MobileSubscriber implements Subscriber{
    String username;
    
    public MobileSubscriber(String username){
        this.username = username;
    }

    @Override
    public void sendNotification(String content, String channelName){
        System.out.println("Sending Mobile Notification to " + username + " for " + channelName + "'s new content - " + content);
    }



}
