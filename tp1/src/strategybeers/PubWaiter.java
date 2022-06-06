package strategybeers;

public class PubWaiter {
  private HappyHourStrategy strategy;
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setStrategy(HappyHourStrategy strategy) {
    this.strategy = strategy;
  }

  public PubWaiter(String name) {
    this.name = name;
  }

  public double calculatePrice(Beer beer) {
    return this.strategy.calculateNewPrice(beer);
  }
}
