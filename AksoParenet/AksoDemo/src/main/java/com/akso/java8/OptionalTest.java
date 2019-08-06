package com.akso.java8;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {
        Optional<String> optional = Optional.ofNullable("hello");
        optional.ifPresent(System.out::println);

        System.out.println("------------");

        System.out.println(optional.orElse("te"));

        System.out.println(optional.orElseGet(() -> "hi"));

        System.out.println(optional.map(x -> x + "test"));

        System.out.println(optional.flatMap(x -> Optional.of(x + "test")));
    }
}
