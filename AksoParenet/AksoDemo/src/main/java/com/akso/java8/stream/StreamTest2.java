package com.akso.java8.stream;

import java.util.stream.IntStream;

public class StreamTest2 {

    public static void main(String[] args) {
        IntStream stream = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9 , 10);
        stream.filter(x -> x % 2 ==0).forEach(System.out::println);

        IntStream stream2 = IntStream.range(3, 10);
        stream2.filter(x -> x % 2 != 0).forEach(System.out::println);

        IntStream stream3 = IntStream.rangeClosed(1, 8);
    }
}
