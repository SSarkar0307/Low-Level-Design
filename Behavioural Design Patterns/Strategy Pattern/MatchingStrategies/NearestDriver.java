package MatchingStrategies;

import MatchingStrategyInterface.MatchingStrategy;

public class NearestDriver implements MatchingStrategy{
    @Override
    public void match(String riderLocation){
        System.out.println("The rider at " + riderLocation + " has been assigned to a driver using Nearest Driver Strategy.");
    }

}
