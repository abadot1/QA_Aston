public class CalcFactorial {
    private static long result = 1;

    public static long calcFactorial(int a) {

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
}
