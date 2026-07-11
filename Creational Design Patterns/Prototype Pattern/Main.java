public class Main{
    public static void main(String[] args) {
        // EmailTemplate email = new EmailTemplate(); // No need of Object Creation anymore.

        EmailTemplate welcomeEmail = EmailTemplateRegistry.getTemplate("welcome");
        EmailTemplate email2 = EmailTemplateRegistry.getTemplate("welcome");
        welcomeEmail.setContent("Welcome to the Company!");
        welcomeEmail.addAttachment(5);
        EmailTemplate email3 = EmailTemplateRegistry.getTemplate("welcome");
        // welcomeEmail.addAttachment();
        welcomeEmail.send("Sohan");
        email2.send("Sarkar");
        email3.send("Receiver");
    }
}