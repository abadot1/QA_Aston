package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //Задание 1
        System.out.println("Задание 1");
        Employee empl = new Employee();
        empl.infoEmployee();

        //Задание 2
        System.out.println("Задание 2");
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivanov@gmail.com", 256987544, 3000, 32);
        persArray[1] = new Person("Ivanov Ivan", "Engineer", "ivanov@gmail.com", 256987544, 3300, 35);
        persArray[2] = new Person("Ivanov Ivan", "Engineer", "ivanov@gmail.com", 256987544, 3300, 48);
        persArray[3] = new Person("Ivanov Ivan", "Engineer", "ivanov@gmail.com", 256987544, 3300, 88);
        persArray[4] = new Person("Ivanov Ivan", "Engineer", "ivanov@gmail.com", 256987544, 3300, 77);

        //задание 3
        System.out.println("Задание 3");
        Park park = new Park();
        park.atraction.dysplayAtraction();

    }
}