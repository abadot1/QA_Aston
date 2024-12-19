package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private HashMap<String, ArrayList<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void add(String surname, String number) {
        if (!phoneBook.containsKey(surname)) {
            ArrayList<String> numbers = new ArrayList<>();
            numbers.add(number);
            phoneBook.put(surname, numbers);

        } else {
            phoneBook.get(surname).add(number);
        }
    }

    public void get(String surname){
        if (phoneBook.containsKey(surname)) {
            System.out.println(surname + ": " + phoneBook.get(surname));
        } else {
            System.out.println("В телефонной книге нет такого контакта");
        }
    }
}
