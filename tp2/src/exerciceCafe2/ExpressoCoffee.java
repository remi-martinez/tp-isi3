package exerciceCafe2;

public class ExpressoCoffee extends Coffee {

    private static final float PRICE = 0.6f;
    private static final String NAME = "Expresso";

    public ExpressoCoffee() {
        setName(NAME);
        setPrice(PRICE);
    }

    public ExpressoCoffee(float price) {
        setName(NAME);
        setPrice(price);
    }
}
