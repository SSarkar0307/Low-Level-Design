import Services.*;

public class MovieBookingFacade {
    NotificationService notificationService;
    PaymentService paymentService;
    SeatReservationService seatReservationService;


    public MovieBookingFacade(){
        this.notificationService = new NotificationService();
        this.paymentService = new PaymentService();
        this.seatReservationService = new SeatReservationService();
    }

    public void bookMovieTicket(String accountId, String movieId, String seatNo, double amount, String userEmail){
        seatReservationService.reserveSeat(movieId, seatNo);
        paymentService.makePayment(accountId, amount);
        notificationService.sendBookingConfirmation(userEmail);

        System.out.println("Movie Booking completed successfully!");
    }
}
