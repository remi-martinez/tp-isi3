package strategycalculette;

public class Division implements ICalculStrategy {

    @Override
    public float calcul(float c1, float c2) {
        try {
            return c1 / c2;
        } catch(ArithmeticException e) {
            e.printStackTrace();
        }
        return 0.0f;
    }
}
