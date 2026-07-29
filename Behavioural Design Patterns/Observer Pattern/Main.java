import Subscribers.*;
import SubscriberInterface.*;
// import ChannelInterface.*;
import Channels.*;

public class Main{
    public static void main(String[] args) {
        Subscriber user001 = new MobileSubscriber("Sohan");
        Subscriber user002 = new EmailSubscriber("Sohan@gmail.com");

        YoutubeChannel mrbeast = new YoutubeChannel("Mr. Beast");
        mrbeast.subscribe(user001);
        mrbeast.subscribe(user002);

        mrbeast.uploadVideo("Surviving 24 Days without a Phone");

    }
}