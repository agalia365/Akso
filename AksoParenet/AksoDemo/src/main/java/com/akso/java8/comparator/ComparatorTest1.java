package com.akso.java8.Comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest1 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("zhangsan", "lisi", "wangwu", "zhang", "zhao");

        list.stream().sorted(Comparator.comparing((String x) -> x.length()).reversed()).forEach(System.out::println);

        System.out.println("-----------------------------");
        Collections.sort(list, Comparator.comparingInt(String::length).reversed());
        list.forEach(System.out::println);
    }
}
