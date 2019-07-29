package com.akso.spring.bean;

public class Person {
    private String name;
    private int age;
    private int salar;

    public Person(String name, int age, int salar) {
        this.name = name;
        this.age = age;
        this.salar = salar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salar=" + salar +
                '}';
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalar() {
        return salar;
    }

    public void setSalar(int salar) {
        this.salar = salar;
    }
}
