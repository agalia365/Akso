package com.akso.java8.methodRef;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceDemo {

    public static void main(String[] args) {
        List<String> list  = Arrays.asList("hello", "world", "hello hi", "how are you");

        list.forEach(System.out::println);
    }
}
