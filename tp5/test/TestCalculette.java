import Calculatrice.Calculatrice;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCalculette {
    @Test
    public void testAjouter(){
        //Given: entrants / donnees d'entrees a tester
        Calculatrice calc = new Calculatrice(4,5);

        //When: execution avec entrants, resultat mis dans sortant
        int resultatEffectif = calc.ajouter();

        //Then: verification des sortants en fonction de ce qui est attendu (oracle)
        int resultatOracle = 9;
        assertEquals(resultatOracle,resultatEffectif);


    }

}
