// Interface
interface RecommendationStrategy {
    void getRecommendations();
}

// Concrete Implementations
class RecentlyAdded implements RecommendationStrategy {
    @Override
    public void getRecommendations() {
        System.out.println("Showing recently added content...");
    }
}

class TrendingNow implements RecommendationStrategy {
    @Override
    public void getRecommendations() {
        System.out.println("Showing trending content...");
    }
}

class GenreBased implements RecommendationStrategy {
    @Override
    public void getRecommendations() {
        System.out.println("Showing content based on your favorite genres...");
    }
}

class RecommendationEngine {
    private RecommendationStrategy strategy;

    // DIP using Dependency Injection 
    public RecommendationEngine(RecommendationStrategy strategy) {
        this.strategy = strategy;
    }

    public void recommend() {
        strategy.getRecommendations();
    }
}

public class Main {
    public static void main(String[] args) {
        // Client Side 
        RecommendationEngine engine = new RecommendationEngine(new TrendingNow());
        engine.recommend();
    }
}
