package exerciceVisiteur2;

import java.util.Stack;

public class ConcreteVisitorInfixDisplay implements Visitor{

    private Stack<String> stack = new Stack<String>();
    //TODO ajouter les parenthèses

    @Override
    public void visiterAddition(Addition addition) {
        addition.getOpG().accept(this);
        stack.push(addition.getOp());
        addition.getOpD().accept(this);
    }

    @Override
    public void visiterMultiplication(Multiplication multiplication) {
        multiplication.getOpG().accept(this);
        stack.push(multiplication.getOp());
        multiplication.getOpD().accept(this);
    }

    @Override
    public void visiterNegation(Negation negation) {
        stack.push(negation.getOp());
        negation.getOpG().accept(this);
    }

    @Override
    public void visiterConstante(Constante constante) {
        stack.push(String.valueOf(constante.getValeur()));
    }

    public String getResult(){
        return stack.toString()
                .replace("[", "")
                .replace("]", "")
                .replace(",","");

    }
}
