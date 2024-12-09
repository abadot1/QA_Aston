package Task1;

public class Dog extends Animal {
    public static int countDog = 0;

    public static void count() {
        countDog = ++countDog;
    }

    public static int getCountDog() {
        return countDog;
    }

    public void runDog(int runDistance) {
        if (runDistance > 500) {
            System.out.println("Собака не может пробежать больше 500 м");
        } else {
            System.out.println(name + " пробежал: " + runDistance + " м");
        }
    }

    public void swimDog(int runSwim) {
        if (runSwim > 10) {
            System.out.println("Собака не может проплыть больше 10 м");
        } else {
            System.out.println(name + " проплыл: " + runSwim + " м");
        }

    }

    public Dog(int runDistance, String name) {
        super(runDistance, name);
        Animal.count();
        Dog.count();
        runDog(runDistance);
    }

    public Dog(String name, int swimDistance) {
        super(name, swimDistance);
        Animal.count();
        Dog.count();;
        swimDog(swimDistance);
    }
}
