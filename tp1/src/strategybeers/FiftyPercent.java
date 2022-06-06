package strategybeers;

public class FiftyPercent implements HappyHourStrategy {

    @Override
    public double calculateNewPrice(Beer b) {
        return b.getPrice() * 0.5;
    }

}
