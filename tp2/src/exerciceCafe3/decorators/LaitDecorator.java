package exerciceCafe3.decorators;

import exerciceCafe3.Article;

public class
LaitDecorator extends SupplementDecorator {

    private static final String NAME = "Lait";
    private static final float PRICE  = 0.1f;

    public LaitDecorator(Article article) {
        super(article);
        this.price = PRICE + article.price;
    }
}
