package strategybeers;

public class TwentyFivePercent implements HappyHourStrategy {

    @Override
    public double calculateNewPrice(Beer b){
        return b.getPrice()*0.75;
    }
}
