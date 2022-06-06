package calculette;


public class Calculette
{
    private float c1;
    private float c2;
    private String operation;

    public float getC1() {
        return c1;
    }

    public void setC1(float c1) {
        this.c1 = c1;
    }

    public float getC2() {
        return c2;
    }

    public void setC2(float c2) {
        this.c2 = c2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Calculette(float c1, float c2, String operation) {
        this.c1 = c1;
        this.c2 = c2;
        this.operation = operation;
    }

    public float calcul(){
        switch (getOperation()){
            case "*":
                return getC1() * getC2();
            case "/":
                try {
                    return getC1() / getC2();
                } catch(ArithmeticException e) {
                    e.printStackTrace();
                }
            case "+":
                return getC1() + getC2();
            case "-":
                return getC1() - getC2();
            default: return 0;
        }
    }
}
