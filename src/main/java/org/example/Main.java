package org.example;

public class Main {
    public static void main(String[] args) {
        new TestArray();

        PhoneBook phoneBook =new PhoneBook();
        phoneBook.add("Иванов", "+375299874563");
        phoneBook.add("Петров", "+375441234569");
        phoneBook.add("Петров", "+375256987412");
        phoneBook.add("Сидоров", "+375332589632");
        phoneBook.add("Иванов", "+375291478963");

        phoneBook.get("Иванов");
    }
}