class DiscountEmail implements EmailTemplate {
    private String subject;
    private String content;

    public DiscountEmail() {
        this.subject = "Heavy Discount!";
        this.content = "Hi there! Massive Discounts in Upcoming Festivals.";
    }

    @Override
    public DiscountEmail clone() {
        try {
            return (DiscountEmail) super.clone();
        } 
        catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void addAttachment(Integer x){
        throw new AssertionError("Discount Doesn't Have attachments.");
    }

    @Override
    public void send(String to) {
        System.out.println("Sending to " + to + ": [" + subject + "] " + content);
    }
}
