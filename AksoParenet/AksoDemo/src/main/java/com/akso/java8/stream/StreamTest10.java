package com.akso.java8.stream;

import java.util.Arrays;
import java.util.List;

public class StreamTest10 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "hello world");

//        list.stream().mapToInt(x -> x.length()).filter(x -> x == 5).findFirst().ifPresent(System.out::println);

        list.stream().mapToInt(x -> {
            System.out.println(x);
            return x.length();
        }).filter( x -> x== 5).findFirst().ifPresent(System.out::println);
    }
}
