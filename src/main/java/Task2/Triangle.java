package Task2;

public class Triangle implements Shape, ColorFilling, ColorBorder {
    public double a;
    public double b;
    public double c;
    public double h;
    public String colorBorder;
    public String colorFilling;

    public Triangle(double a, double b, double c, double h){
        this.a = a;
        this.b = b;
        this.c = c;
        this.h = h;
    }

    @Override
    public double calculatePerimeter() {
        return a + b + c;
    }

    @Override
    public double calculateArea() {
        return 0.5 * a * h;
    }

    @Override
    public void colorBorder(String colorBorder) {
        this.colorBorder = colorBorder;
    }

    @Override
    public void colorFilling(String colorFilling) {
        this.colorFilling = colorFilling;
    }

    public void getCircle(){
        System.out.println("Треугольник:");
        System.out.println("Периметр: " + calculatePerimeter());
        System.out.println("Площадь: " + calculateArea());
        System.out.println("Цвет заливки: " + colorFilling);
        System.out.println("Цвет границы: " + colorBorder);
    }
}
