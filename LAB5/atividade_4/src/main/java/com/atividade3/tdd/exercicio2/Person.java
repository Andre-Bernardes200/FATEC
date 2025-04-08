package com.atividade3.tdd.exercicio2;

import java.util.List;

public class Person {

    int id;
    String name;
    int age;
    List<Email> emails;

    public Person(int id, String name, int age, List<Email> emails) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.emails = emails;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public List<Email> getEmails() { return emails; }
}
