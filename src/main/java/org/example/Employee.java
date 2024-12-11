package org.example;

public class Employee {
    protected String fullNname;
    protected String jobTitle;
    protected String email;
    protected int phone;
    protected int salary;
    protected int age;

    public Employee() {
        fullNname = "Иванов Иван Иванович";
        jobTitle = "мастер";
        email = "ivanov@gmail.com";
        phone = 256986547;
        salary = 3000;
        age = 35;
    }

    public void infoEmployee() {
        System.out.println("ФИО: " + fullNname + ", должность: " + jobTitle +
                ", email: " + email + ", телефон: " + phone + ", зарплата: " + salary
                + ", возраст: " + age);
    }


}
