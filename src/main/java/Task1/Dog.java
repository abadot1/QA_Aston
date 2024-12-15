package Task1;

public class Dog extends Animal {
    protected static int countDog = 0;

    public void run(String name, int distance) {
        ++Animal.countAnimal;
        ++countDog;
        if (distance > 500) {
            System.out.println("Собака не может пробежать больше 500 м");
        } else {
            System.out.println(name + " пробежал: " + distance + " м");
        }
    }

    public void swim(String name, int distance) {
        ++Animal.countAnimal;
        ++countDog;
        if (distance > 10) {
            System.out.println("Собака " + name + " не может проплыть больше 10 м");
        } else {
            System.out.println("Собака " + name + " проплыл: " + distance + " м");
        }

    }

    
}
