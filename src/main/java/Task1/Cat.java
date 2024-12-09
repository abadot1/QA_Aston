package Task1;


public class Cat extends Animal {
    public static int countCat = 0;
    public static int bowlFood = 20;
    public boolean satiety;
    public int needFood;

    public static void addFoodBowl(int add){
     bowlFood = bowlFood + add;
        System.out.println("Добавлен корм");
    }
    public static void eatCat(String name, int needFood, boolean satiety) {
        if (bowlFood <= 0) {
            System.out.println("Миска пуста");
            addFoodBowl(5);
            eatCat(name, needFood, satiety);
        } else {
            if (bowlFood < needFood) {
                System.out.println(name + " остался голодный. Сытость: " + satiety);
                addFoodBowl(5);
                eatCat(name, needFood, satiety);
            } else {
                bowlFood = bowlFood - needFood;
                satiety = true;
                System.out.println(name + " съел " + needFood + "г. корма. Сытость: " + satiety);
                System.out.println("Осталось " + bowlFood + "г. корма в миске");
            }
        }
    }


    public static void count() {
        countCat = ++countCat;
    }

    public static int getCountCat() {
        return countCat;
    }

    public void runCat(int runDistance) {
        if (runDistance > 200) {
            System.out.println("Кот не может пробежать больше 200 м");
        } else {
            System.out.println(name + " пробежал: " + runDistance + " м");
        }
    }

    public void swimCat(String name) {
        System.out.println("Кот " + name + " не может плавать");

    }


    public Cat(int runDistance, String name, boolean satiety, int needFood) {
        super(runDistance, name);
        this.satiety = satiety;
        this.needFood = needFood;
        Animal.count();
        Cat.count();
        runCat(runDistance);


    }

    public Cat(String name, int swimDistance, boolean satiety, int needFood) {
        super(name, swimDistance);
        this.satiety = satiety;
        this.needFood = needFood;
        Animal.count();
        Cat.count();
        swimCat(name);

    }
}
