package exerciceVisiteur2;

import java.util.Stack;

public class ConcreteVisitorPostfixDisplay implements Visitor{

    private Stack<String> stack = new Stack<String>();

    @Override
    public void visiterAddition(Addition addition) {
        addition.getOpG().accept(this);
        addition.getOpD().accept(this);
        stack.push(addition.getOp());

    }

    @Override
    public void visiterMultiplication(Multiplication multiplication) {
        multiplication.getOpG().accept(this);
        multiplication.getOpD().accept(this);
        stack.push(multiplication.getOp());
    }

    @Override
    public void visiterNegation(Negation negation) {
        negation.getOpG().accept(this);
        stack.push(negation.getOp());

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
