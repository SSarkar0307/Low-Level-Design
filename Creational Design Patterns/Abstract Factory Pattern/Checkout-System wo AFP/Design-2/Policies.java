import java.util.*;
class IndianPolicy implements RegionPolicy{

    private final Set<String> gateways = Set.of("razorpay","payu");
    
    @Override
    public boolean supportsGateway(String gateway) {
        return gateways.contains(gateway.toLowerCase());
    }
}
class USPolicy implements RegionPolicy{

    private final Set<String> gateways = Set.of("stripe", "paypal");
    
    @Override
    public boolean supportsGateway(String gateway) {
        return gateways.contains(gateway.toLowerCase());
    }
}