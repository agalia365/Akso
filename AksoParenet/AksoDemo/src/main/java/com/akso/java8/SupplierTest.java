package com.akso.java8;

import java.util.function.Supplier;

public class SupplierTest {

    public static void main(String[] args) {
        Supplier<String> supplier = () -> "hello supplier";
        System.out.println(supplier.get());
    }
}
