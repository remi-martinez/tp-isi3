package exerciceCafe3.decorators;

import exerciceCafe3.Article;

public abstract class SupplementDecorator extends Article {

    private Article article;

    public SupplementDecorator(Article article) {
        this.article = article;
    }
}
