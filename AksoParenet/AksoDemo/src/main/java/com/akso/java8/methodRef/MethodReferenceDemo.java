package com.akso.java8.methodRef;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MethodReferenceDemo {

    public static void main(String[] args) {
        List<String> list  = Arrays.asList("hello", "world", "hello hi", "how are you");

        list.forEach(System.out::println);

        list.forEach(x -> System.out.println(x));

        Stream stream = Stream.of("hello", "world", "how", "are you", 1, 2);
    }
}
