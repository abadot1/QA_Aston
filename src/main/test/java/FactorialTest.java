import org.junit.Assert;
import org.junit.Test;


public class FactorialTest {

    private long result = 1;

    public long calcFactorial(int a) {
        if (a < 0) {
            throw new IllegalArgumentException("Факториал нельзя рассчитать");
        }
        if (a == 0) {
            return 1;
        } else {
            for (int i = 1; i <= a; i++) {
                result *= i;
            }
            return result;
        }

    }

    @Test
    public void factorialZeroTest() {
        Assert.assertEquals(1, calcFactorial(0));
    }

    @Test
    public void factorialNumberTest() {
        Assert.assertEquals(720, calcFactorial(6));
    }

    @Test
    public void factorialNegativeNumberTest() {
        Assert.assertThrows(IllegalArgumentException.class, () -> calcFactorial(-6));
    }

}
