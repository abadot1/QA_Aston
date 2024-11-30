package org.example;

public class Person {
    String fullName;
    String jobTitle;
    String email;
    int phone;
    int salary;
    int age;

    Person(String fullName, String jobTitle, String email, int phone,
           int salary, int age) {
        this.fullName = fullName;
        this.jobTitle = jobTitle;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }
}
