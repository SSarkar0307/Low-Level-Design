package NotificationSenders;
import NotificationSenderTemplate.*;

public class SMSNotification extends NotificationSender{
    @Override
    protected String composeMessage(String formattedMessage) {
        return "[SMS]" + formattedMessage;
    }

    @Override
    protected void sendMessage(String to, String message) {
        System.out.println("Sending SMS to " + to + " with content:\n" + message);
    }

    @Override
    protected void postSendAnalytics(String to){
        System.out.println("Custom SMS Analytics updating for : " + to);
    }
}
