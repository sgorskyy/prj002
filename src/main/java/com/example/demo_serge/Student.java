package com.example.demo_serge;

import lombok.Data;

@Data
public class Student {
    private int id;
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
