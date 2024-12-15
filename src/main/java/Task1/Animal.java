package Task1;

public class Animal {
    protected static int countAnimal = 0;

    public static void count() {
        countAnimal = ++countAnimal;
    }

    public static int getCount() {
        return countAnimal;
    }

    public void run() {
    }

    public void swim() {
    }

}
