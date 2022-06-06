package exerciceCafe2;

public class DecaCoffee extends Coffee {

    private static final float PRICE = 0.4f;
    private static final String NAME = "Deca";

    public DecaCoffee() {
        setName(NAME);
        setPrice(PRICE);
    }

    public DecaCoffee(float price) {
        setName(NAME);
        setPrice(price);
    }
}
