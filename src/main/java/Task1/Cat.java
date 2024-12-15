package Task1;


public class Cat extends Animal {
    protected static int countCat = 0;
    protected String name;
    protected boolean satiety;
    protected int needFood;

    public Cat() {
    }

    public Cat(String name, boolean satiety, int needFood) {
        this.name = name;
        this.satiety = satiety;
        this.needFood = needFood;
    }

    public void run(String name, int distance) {
        ++Animal.countAnimal;
        ++countCat;
        if (distance > 200) {
            System.out.println("Кот " + name + " не может пробежать больше 200 м");
        } else {
            System.out.println("Кот " + name + " пробежал: " + distance + " м");
        }
    }

    public void swim(String name, int distance) {
        ++Animal.countAnimal;
        ++countCat;
        System.out.println("Кот " + name + " не может плавать");
    }

    public void eatFood(Bowl bowl, String name, int needFood) {
        if (this.satiety == false) {
            if (needFood > bowl.food) {
                System.out.println("Кот " + name + " остался голодный");
            } else {
                bowl.food = bowl.food - needFood;
                this.satiety = true;
                System.out.println("Кот " + name + " поел");
            }
        } else {
            System.out.println("Кот " + name + " сыт");
        }
    }
}
