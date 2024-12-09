package Task1;

public class Animal {
    public String name;
    public int runDistance;
    public int swimDistance;
    public static int countAnimal = 0;

    public static void count(){
        countAnimal = ++countAnimal;
    }

    public static int getCountAnimal(){
        return countAnimal;
    }

    public Animal(int runDistance, String name) {
        this.name = name;
        this.runDistance = runDistance;
    }

    public Animal(String name, int swimDistance) {
        this.name = name;
        this.swimDistance = swimDistance;
    }




}
