package strategycalculette;

public class Addition implements ICalculStrategy {

    @Override
    public float calcul(float c1, float c2) {
        return c1 + c2;
    }
}
