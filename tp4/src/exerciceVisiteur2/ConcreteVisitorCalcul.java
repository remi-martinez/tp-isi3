package exerciceVisiteur2;

import java.util.Stack;

public class ConcreteVisitorCalcul implements Visitor{

    private Stack<Integer> stack = new Stack<Integer>(); //On crée une stack qui va

    @Override
    public void visiterAddition(Addition addition) {
        addition.getOpG().accept(this);
        addition.getOpD().accept(this);

        int chiffre1 = stack.pop();
        int chiffre2 = stack.pop();

        stack.push(chiffre1 + chiffre2);
    }

    @Override
    public void visiterMultiplication(Multiplication multiplication) {
        multiplication.getOpG().accept(this);
        multiplication.getOpD().accept(this);

        int chiffre1 = stack.pop();
        int chiffre2 = stack.pop();

        stack.push(chiffre1 * chiffre2);
    }

    @Override
    public void visiterNegation(Negation negation) {
        negation.getOpG().accept(this);

        int chiffre1 = stack.pop();
        stack.push(-chiffre1);
    }

    @Override
    public void visiterConstante(Constante constante) {
        stack.push(constante.getValeur());
    }

    public int getResult(){
        return stack.firstElement();
    }
}
