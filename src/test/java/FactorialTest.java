import org.junit.Assert;
import org.junit.Test;

public class FactorialTest {

    @Test
    public void factorialZeroTest() {
        Assert.assertEquals(1, CalcFactorial.calcFactorial(0));
    }

    @Test
    public void factorialNumberTest() {
        Assert.assertEquals(720, CalcFactorial.calcFactorial(6));
    }

    @Test
    public void factorialNegativeNumberTest() {
        Assert.assertThrows(IllegalArgumentException.class, () -> CalcFactorial.calcFactorial(-6));
    }

}
