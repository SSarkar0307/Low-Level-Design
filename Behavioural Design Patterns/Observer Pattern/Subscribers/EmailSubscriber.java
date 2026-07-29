package Subscribers;

import SubscriberInterface.*;

public class EmailSubscriber implements Subscriber{
    String username;
    public EmailSubscriber(String username){
        this.username = username;
    }

    @Override
    public void sendNotification(String content, String channelName){
        System.out.println("Sending Email Notification to " + username + " for " + channelName + "'s new content - " + content);
    }
    
}
