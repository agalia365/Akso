package com.akso.java8.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest1 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "hworldaaa", "nihao", "welcome");

        list.stream().sorted(Comparator.comparingInt(String::length).thenComparing(String.CASE_INSENSITIVE_ORDER)).forEach(System.out::println);

        System.out.println("-----------------");
        list.stream().sorted(Comparator.comparing(String::length, Comparator.reverseOrder()).thenComparing(String::toLowerCase, Comparator.reverseOrder()))
            .forEach(System.out::println);

        System.out.println("-----------------");
        list.stream().sorted(Comparator.comparingInt(String::length).reversed().thenComparing(String::toLowerCase, Comparator.reverseOrder()))
                .forEach(System.out::println);

        list.stream().sorted(Comparator.comparingInt(String::length).reversed());

        list.stream().sorted(Comparator.comparingInt(String::length).reversed());

        Collections.sort(list, Comparator.comparingInt(item -> item.length()));
    }
}
