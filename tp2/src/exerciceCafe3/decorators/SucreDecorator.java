package exerciceCafe3.decorators;

import exerciceCafe3.Article;

public class SucreDecorator extends SupplementDecorator {

    private static final String NAME = "Lait";
    private static final float PRICE  = 0.1f;

    public SucreDecorator(Article article) {
        super(article);
        this.price = PRICE + article.price;
    }
}
