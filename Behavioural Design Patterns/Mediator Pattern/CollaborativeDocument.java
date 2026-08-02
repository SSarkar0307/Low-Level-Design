import java.util.*;

public class CollaborativeDocument implements Mediator{
    String documentName;
    List<User> users = new ArrayList<>();

    public CollaborativeDocument(String documentName){
        this.documentName = documentName;
    }

    @Override
    public String getDetails(){
        return documentName;
    }

    @Override
    public void broadcastChange(String change, User sender){
        for(User user : users){
            if(user != sender){
                user.receiveChange(change, sender, documentName);
            }
        }
    }

    @Override
    public void join(User user){
        users.add(user);
    }
}