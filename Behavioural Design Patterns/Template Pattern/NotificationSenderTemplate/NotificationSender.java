package NotificationSenderTemplate;

public abstract class NotificationSender {
    public final void send(String to, String rawMessage){
        // Common Logic (Template)
        rateLimitCheck(to);
        validateRecipient(to);
        String formattedMessage = formatMessage(rawMessage);
        
        // Self-written Logic
        String composedMessage = composeMessage(formattedMessage);
        sendMessage(to, composedMessage);

        // Optional (Can be overriden)
        postSendAnalytics(to);
    }   
    
    private void rateLimitCheck(String to){
        System.out.println("Rate Limit Check Running for " + to);
    }

    private void validateRecipient(String to){
        System.out.println("Validing Recipient " + to);
    }

    private String formatMessage(String rawMessage){
        return rawMessage.trim();
    }

    protected abstract String composeMessage(String formattedMessage);
    protected abstract void sendMessage(String to, String composedMessage);

    protected void postSendAnalytics(String to){
        System.out.println("Analytics updated for: " + to);
    } 
}
