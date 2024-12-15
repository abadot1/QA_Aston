package Task2;

public interface Shape {
    double calculatePerimeter();
    double calculateArea();

    default void printPerimetrAndArea(){
        System.out.println("Периметр: " + calculatePerimeter());
        System.out.println("Площадь: " + calculateArea());
    }
}
