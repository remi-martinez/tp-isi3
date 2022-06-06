package exerciceCafe1;

public abstract class Coffee {
    private String name;
    private float price;
    
    @Override
    public String toString(){
        return String.format("%s (%.2f€)", getName(), getPrice());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice(){
        return price;
    }

    public void setPrice(float price){
        this.price = price;
    }
}
