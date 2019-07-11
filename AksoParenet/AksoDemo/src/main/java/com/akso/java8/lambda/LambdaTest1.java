package com.akso.java8.lambda;

import java.util.Arrays;
import java.util.List;

public class LambdaTest1 {

    public static void main(String[] args) {
        String test = "test";
        List<String> list = Arrays.asList("hello", "world", "hello world");
        list.stream().map(x -> {
            System.out.println(test);
            return x + " haha " + test;
        }).forEach(System.out::println);
    }
}
