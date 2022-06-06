package strategycalculette;


public class CalculetteStrat {
    private ICalculStrategy calculStrategy;

    private float c1;
    private float c2;

    public CalculetteStrat(float c1, float c2) {
        this.calculStrategy = calculStrategy;
        this.c1 = c1;
        this.c2 = c2;
    }

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

    public void setCalculStrategy(ICalculStrategy calculStrategy) {
        this.calculStrategy = calculStrategy;
    }

    public float calcul(){
        return this.calculStrategy.calcul(getC1(),getC2());
    }
}
