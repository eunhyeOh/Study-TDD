package test.java.chap02;

import main.java.Calulator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    void puls(){
        int result = Calulator.plus(1,2);
        assertEquals(3, result);
        assertEquals(5, Calulator.plus(4,1));
    }
}
