public class RegionHelper{
    public static RegionPolicy getRegionPolicy(String region){
        if(region.equalsIgnoreCase("India")) return new IndianPolicy();
        else if(region.equalsIgnoreCase("US")) return new USPolicy();
        throw new IllegalArgumentException("No Policies for: "+ region);
    }
}