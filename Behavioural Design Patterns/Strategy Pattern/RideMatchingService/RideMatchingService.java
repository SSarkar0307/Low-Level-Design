package RideMatchingService;

import MatchingStrategyInterface.MatchingStrategy;

public class RideMatchingService{
    MatchingStrategy matchingStrategy;

    public RideMatchingService(MatchingStrategy strategy){
        this.matchingStrategy = strategy;
    }

    public void changeStrategy(MatchingStrategy strategy){
        this.matchingStrategy = strategy;
    }

    public void matchRider(String riderLocation){
        matchingStrategy.match(riderLocation);
    }
}