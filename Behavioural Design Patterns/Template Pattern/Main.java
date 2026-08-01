import NotificationSenderTemplate.NotificationSender;
import NotificationSenders.EmailNotification;
import NotificationSenders.SMSNotification;

public class Main{
    public static void main(String[] args) {
        NotificationSender emailSender = new EmailNotification();
        emailSender.send("sohan@gmail.com", "Welcome onboard!");
        
        NotificationSender smsSender = new SMSNotification();
        smsSender.send("9876543210", "Your plan expires today!");
    }
}