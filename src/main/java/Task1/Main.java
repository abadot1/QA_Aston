package Task1;

public class Main {
    public static void main(String[] args) {

        Dog bobik = new Dog(470, "Bobik");

        Dog sharik = new Dog("Sharik", 25);

        Cat[] cats;
        cats = new Cat[3];
        cats[0] = new Cat(22, "Barsik", false, 10);
        cats[1] = new Cat("Bosia", 44, false, 13);
        cats[2] = new Cat(147, "Murka", false, 15);

        for (int i = 0; i < cats.length; i++){
            Cat.eatCat(cats[i].name, cats[i].needFood, cats[i].satiety);
        }

        System.out.println("Count Animal: " + Animal.getCountAnimal());
        System.out.println("Count Cat: " + Cat.getCountCat());
        System.out.println("Count Dog: " + Dog.getCountDog());
    }
}