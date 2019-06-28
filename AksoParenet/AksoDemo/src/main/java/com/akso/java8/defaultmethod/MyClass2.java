package com.akso.java8.defaultmethod;

public class MyClass2 extends MyClass implements MyInterface2, MyInterface1 {

    @Override
    public String getString() {
        return super.getString();
    }
}
