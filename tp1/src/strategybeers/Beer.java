package strategybeers;

public class Beer {
  private double price;
  private String brand;

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public Beer(String brand, double price) {
    this.price = price;
    this.brand = brand;
  }
}
