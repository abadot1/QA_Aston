package Task2;

public class Rectangle implements Shape, Color {
    private double a;
    private double b;
    private String colorBorder;
    private String colorFilling;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (a + b);
    }

    @Override
    public double calculateArea() {
        return a * b;
    }

    @Override
    public void colorBorder(String colorBorder) {
        this.colorBorder = colorBorder;
    }

    @Override
    public void colorFilling(String colorFilling) {
        this.colorFilling = colorFilling;
    }

    public void getRectangle() {
        System.out.println("Прямоугольник:");
        printPerimetrAndArea();
        System.out.println("Цвет заливки: " + colorFilling);
        System.out.println("Цвет границы: " + colorBorder);
    }
}
