package com.akso.spring.bean;

public class Car {

    public Car() {
        System.out.println("创建car.........");
    }

    public void init() {
        System.out.println("init .......");
    }

    public void destroy() {
        System.out.println("destroy..............");
    }
}
