package com.akso.java8.stream;

import java.util.stream.Stream;

public class StreamTest7 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("hello", "world", "hello world");
//        stream.map(item -> item.substring(0, 1).toUpperCase() + item.substring(1)).forEach(System.out::println);

        stream.map(item -> {
            String res = item.substring(0, 1).toUpperCase() + item.substring(1);
            System.out.println(res);
            return res;
        });
    }

}
