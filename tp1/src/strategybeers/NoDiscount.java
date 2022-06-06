package strategybeers;

public class NoDiscount implements HappyHourStrategy {

    @Override
    public double calculateNewPrice(Beer b){
        return b.getPrice();
    }


}
