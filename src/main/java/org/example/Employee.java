package org.example;

public class Employee {
    String fullNname;
    String jobTitle;
    String email;
    int phone;
    int salary;
    int age;

    Employee() {
        fullNname = "Иванов Иван Иванович";
        jobTitle = "мастер";
        email = "ivanov@gmail.com";
        phone = 256986547;
        salary = 3000;
        age = 35;
    }

    void infoEmployee() {
        System.out.println("ФИО: " + fullNname + ", должность: " + jobTitle +
                ", email: " + email + ", телефон: " + phone + ", зарплата: " + salary
                + ", возраст: " + age);
    }


}
