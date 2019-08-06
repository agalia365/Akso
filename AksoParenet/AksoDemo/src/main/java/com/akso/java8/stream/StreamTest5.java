package com.akso.java8.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest5 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("hello", "world", "hello world");

        List<String> list = stream.map(String::toUpperCase).collect(Collectors.toList());

        list.forEach(System.out::println);
    }
}
