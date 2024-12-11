package org.example;

public class Person {
    protected String fullName;
    protected String jobTitle;
    protected String email;
    protected int phone;
    protected int salary;
    protected int age;

    public Person(String fullName, String jobTitle, String email, int phone,
                  int salary, int age) {
        this.fullName = fullName;
        this.jobTitle = jobTitle;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }
}
