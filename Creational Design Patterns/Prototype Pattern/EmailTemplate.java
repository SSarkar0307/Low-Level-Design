public interface EmailTemplate extends Cloneable{
    EmailTemplate clone();
    void setContent(String content);
    void addAttachment(Integer x);
    void send(String to);
}