import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FactorialTest {
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
        CalcFactorial.result = 1;
        Assert.assertEquals(factorial, CalcFactorial.calcFactorial(num));
    }

    @Test
    public void factorialNegativeNumberTest() {
        Assert.assertThrows(IllegalArgumentException.class, () -> CalcFactorial.calcFactorial(-6));
    }
}
