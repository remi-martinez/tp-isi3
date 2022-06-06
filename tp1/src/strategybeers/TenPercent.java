package strategybeers;

public class TenPercent implements HappyHourStrategy {

    @Override
    public double calculateNewPrice(Beer b) {
        return b.getPrice() * 0.9;
    }

}
