public class Main{
    public static void main(String[] args) {
        MovieBookingFacade movieBookingFacade = new MovieBookingFacade();
        movieBookingFacade.bookMovieTicket("user001", "Spiderman : Brand New Day", "J21", 610.00, "user@gmail.com");
    }
}