package exerciceCafe3;

public abstract class Article {
    public String name;
    public float price;

    public String getName(){
        return name;
    };
    public float getPrice(){
        return price;
    };

    public String getFormattedPrice() {
        return String.format("%.02f", price);
    }
}
