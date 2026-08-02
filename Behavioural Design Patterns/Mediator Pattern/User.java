public class User {
    protected String username;
    protected Mediator mediator;

    public User(String username, Mediator mediator){
        this.username = username;
        this.mediator = mediator;
    }

    public void makeChange(String change){
        System.out.println(username + " made changes: " + mediator.getDetails() + " in document: ");
        mediator.broadcastChange(change, this);
    }

    public void receiveChange(String change, User sender, String docName){
        System.out.println(username + " viewed the change in " + docName + " made by " + sender.username);
    }
}
