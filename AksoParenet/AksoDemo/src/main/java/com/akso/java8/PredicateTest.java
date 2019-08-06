package com.akso.java8;

import java.util.function.Predicate;

public class PredicateTest {

    public static void main(String[] args) {
        Predicate<String> predicate = x -> x.length() > 5;

        System.out.println(predicate.test("hellox"));
    }
}
