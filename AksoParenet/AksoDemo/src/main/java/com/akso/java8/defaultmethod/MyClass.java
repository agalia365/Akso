package com.akso.java8.defaultmethod;

public class MyClass implements MyInterface1, MyInterface2{

    @Override
    public String getString() {
        return MyInterface1.super.getString();
    }
}
