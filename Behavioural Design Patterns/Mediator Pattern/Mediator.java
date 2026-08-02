public interface Mediator {
    void broadcastChange(String change, User sender);
    void join(User user);
    String getDetails();
}
