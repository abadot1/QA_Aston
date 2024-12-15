package Task2;


public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(2);
        circle.colorFilling("red");
        circle.colorBorder("black");
        circle.getCircle();

        Rectangle rectangle = new Rectangle(2, 4);
        rectangle.colorFilling("red");
        rectangle.colorBorder("black");
        rectangle.getRectangle();

        Triangle triangle = new Triangle(2, 4, 5);
        triangle.colorFilling("red");
        triangle.colorBorder("black");
        triangle.getTriangle();
    }
}