package NotificationSenders;
import NotificationSenderTemplate.*;

public class EmailNotification extends NotificationSender{
    @Override
    protected String composeMessage(String formattedMessage) {
        return "<html><body><p>" + formattedMessage + "</p></body></html>";
    }

    @Override
    protected void sendMessage(String to, String message) {
        System.out.println("Sending Email to " + to + " with content:\n" + message);
    }
}
