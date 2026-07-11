import java.util.*;

class EmailTemplateRegistry{
    private static final HashMap<String, EmailTemplate> templates = new HashMap<>();

    // Store every template already at compile time, and later just clone the needed one and provide to client.
    static{
        templates.put("welcome", new WelcomeEmail());        
        templates.put("discount", new DiscountEmail());        
    }

    public static EmailTemplate getTemplate(String type){
        return templates.get(type).clone();
    }
}