package com.example.lenovo.lecture12.models;

/**
 * Created by lenovo on 7/12/2016.
 */
public class Students {
    int id;
    String name;
    int studentClass;
    int age;
    //sugar orm
    //active android

    public Students(int id, String name, int studentClass, int age) {
        this.id = id;
        this.name = name;
        this.studentClass = studentClass;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getStudentClass() {
        return studentClass;
    }
}
