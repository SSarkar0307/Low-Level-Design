import java.util.*;

class WelcomeEmail implements EmailTemplate {
    private String subject;
    private String content;
    private List<Integer> attachment;

    public WelcomeEmail() {
        this.subject = "Welcome!";
        this.content = "Hi there! Thanks for joining us.";
        this.attachment = new ArrayList<>(List.of(1,2,3));
    }

    @Override
    public WelcomeEmail clone() {
        try {
            WelcomeEmail clonedEmail =(WelcomeEmail) super.clone();
            if(this.attachment != null){
                clonedEmail.attachment = new ArrayList<>(this.attachment);
            }
            return clonedEmail;
        } 
        catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    public void addAttachment(Integer x){
        this.attachment.add(x);
    }

    @Override
    public void send(String to) {
        System.out.println("Sending to " + to + ": [" + subject + "] " + content + " with Attachments: " + attachment);
    }
}
