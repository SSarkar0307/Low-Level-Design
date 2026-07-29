package MatchingStrategies;

import MatchingStrategyInterface.MatchingStrategy;

public class DriverRating implements MatchingStrategy{
    @Override
    public void match(String riderLocation){
        System.out.println("The rider at " + riderLocation + " has been assigned to a driver of the Highest Rating on the App.");
    }

}
