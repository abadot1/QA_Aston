package Task2;

public class Triangle implements Shape, Color {
    private double a;
    private double b;
    private double c;
    private String colorBorder;
    private String colorFilling;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double calculatePerimeter() {
        return a + b + c;
    }

    @Override
    public double calculateArea() {
        return Math.sqrt(calculatePerimeter() / 2 * (calculatePerimeter() / 2 - a) * (calculatePerimeter() / 2 - b)
                * (calculatePerimeter() / 2 - c));
    }

    @Override
    public void colorBorder(String colorBorder) {
        this.colorBorder = colorBorder;
    }

    @Override
    public void colorFilling(String colorFilling) {
        this.colorFilling = colorFilling;
    }

    public void getTriangle() {
        System.out.println("Треугольник:");
        printPerimetrAndArea();
        System.out.println("Цвет заливки: " + colorFilling);
        System.out.println("Цвет границы: " + colorBorder);
    }
}
