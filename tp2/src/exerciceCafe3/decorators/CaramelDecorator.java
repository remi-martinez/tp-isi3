package exerciceCafe3.decorators;

import exerciceCafe3.Article;

public class CaramelDecorator extends SupplementDecorator {

    private static final String NAME = "Caramel";
    private static final float PRICE  = 0.2f;

    public CaramelDecorator(Article article) {
        super(article);
        this.price = PRICE + article.price;
    }
}
