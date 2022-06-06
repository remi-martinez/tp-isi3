package exerciceVisiteur2;

public interface Visitor {

    void visiterAddition(Addition addition);
    void visiterMultiplication(Multiplication multiplication);
    void visiterNegation(Negation negation);
    void visiterConstante(Constante constante);
}
