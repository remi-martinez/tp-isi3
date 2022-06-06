package exerciceCafe3.decorators;

import exerciceCafe3.Article;

public class ChantillyDecorator extends SupplementDecorator {

    private static final String NAME = "Chantilly";
    private static final float PRICE  = 0.4f;

    public ChantillyDecorator(Article article) {
        super(article);
        this.price = PRICE + article.price;
    }
}
