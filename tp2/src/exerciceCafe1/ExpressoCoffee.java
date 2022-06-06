package exerciceCafe1;

public class ExpressoCoffee extends Coffee {

    private static final float PRICE = 0.6f;

    ExpressoCoffee() {
        setName("Expresso");
        setPrice(PRICE);
    }

    ExpressoCoffee(float price) {
        setName("Expresso");
        setPrice(price);
    }
}
