import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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

    @DataProvider
    public Object[][] numbers() {
        return new Object[][]{
                {0, 1},
                {1, 1},
                {2, 2},
                {3, 6},
                {4, 24},
        };
    }

    @Test(dataProvider = "numbers")
    public void factorialNumberTest(int num, int factorial) {
        result = 1;
        Assert.assertEquals(factorial, calcFactorial(num));
    }

    @Test
    public void factorialNegativeNumberTest() {
        Assert.assertThrows(IllegalArgumentException.class, () -> calcFactorial(-6));
    }
}
