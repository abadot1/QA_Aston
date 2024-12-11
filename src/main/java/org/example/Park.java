package org.example;

public class Park {
    public Atraction atraction = new Atraction("Колесо обозрения", 10, 9, 20);

    public class Atraction {
        public String name;
        public int price;
        public int openingTime;
        public int closingTime;


        public Atraction(String name, int price, int openingTime, int closingTime) {
            this.name = name;
            this.price = price;
            this.openingTime = openingTime;
            this.closingTime = closingTime;
        }

        public void dysplayAtraction() {
            System.out.println(name + " работает с " + openingTime + " до " + closingTime + "часов");
            System.out.println("Стоимость " + price + " руб.");
        }
    }
}
