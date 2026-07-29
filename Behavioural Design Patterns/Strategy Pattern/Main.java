import MatchingStrategies.DriverRating;
import MatchingStrategies.NearestDriver;
import RideMatchingService.RideMatchingService;

public class Main{
    public static void main(String[] args) {
        RideMatchingService rideBook = new RideMatchingService(new DriverRating());

        rideBook.matchRider("New York");
        
        rideBook.changeStrategy(new NearestDriver());
        rideBook.matchRider("New York");
    }
}