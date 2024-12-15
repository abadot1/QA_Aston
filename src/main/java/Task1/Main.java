package Task1;

public class Main {
    public static void main(String[] args) {

        Cat murka = new Cat();
        murka.run("Мурка", 300);
        Cat sosiska = new Cat();
        sosiska.swim("Сосиска", 4);
        Cat murzik = new Cat();
        murzik.run("Мурзик", 100);

        Dog bobik = new Dog();
        bobik.run("Бобик", 400);
        Dog sharik = new Dog();
        sharik.swim("Шарик", 5);

        Bowl bowl = new Bowl(30);

        Cat[] cats;
        cats = new Cat[3];
        cats[0] = new Cat("Мурка", false, 20);
        cats[1] = new Cat("Сосиска", false, 15);
        cats[2] = new Cat("Мурзик", false, 10);

        for (int i = 0; i < cats.length; i++){
            cats[i].eatFood(bowl, cats[i].name,  cats[i].needFood );
        }

        bowl.addFood(40);

        for (int i = 0; i < cats.length; i++){
            cats[i].eatFood(bowl, cats[i].name,  cats[i].needFood );
        }

        System.out.println("Count Animal: " + Animal.countAnimal);
        System.out.println("Count Cat: " + Cat.countCat);
        System.out.println("Count Dog: " + Dog.countDog);
    }
}