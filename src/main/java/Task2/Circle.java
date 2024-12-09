package Task2;

public class Circle implements Shape, ColorFilling, ColorBorder {
    public double radius;
    public String colorBorder;
    public String colorFilling;

    public Circle(double radius){
        this.radius = radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
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
        System.out.println("Круг:");
        System.out.println("Периметр: " + calculatePerimeter());
        System.out.println("Площадь: " + calculateArea());
        System.out.println("Цвет заливки: " + colorFilling);
        System.out.println("Цвет границы: " + colorBorder);
    }
}
