package com.akso.java8.stream;

import java.util.Arrays;
import java.util.List;

public class StreamTest11 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello world", "hello welcome", "welcome", "hello welcome");
        list.stream().map(x -> x.split(" ")).flatMap(x -> Arrays.stream(x)).distinct().forEach(System.out::println);
    }
}
