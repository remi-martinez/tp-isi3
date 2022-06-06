package exerciceCafe2;

public class ColombiaCoffee extends Coffee {

    private static final float PRICE = 0.5f;
    private static final String NAME = "Colombia";

    public ColombiaCoffee() {
        setName(NAME);
        setPrice(PRICE);
    }

    public ColombiaCoffee(float price) {
        setName(NAME);
        setPrice(price);
    }
}
