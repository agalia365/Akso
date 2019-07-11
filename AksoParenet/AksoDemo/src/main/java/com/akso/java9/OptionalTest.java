package com.akso.java9;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class OptionalTest {

    @Test
    public void test1() {
        List<String> list = Arrays.asList("Tom", "Jim", "Toy", "Lee");

        Optional<List<String>> optional = Optional.ofNullable(list);
        optional.stream().forEach(System.out::println);
    }

    @Test
    public void test2() {
        List<String> list = Arrays.asList("Tom", "Jim", "Toy", "Lee");
        Optional<List<String>> optional = Optional.ofNullable(list);
        Stream<String> stream = optional.stream().flatMap(x -> x.stream());
        System.out.println(stream.count());
    }

}
