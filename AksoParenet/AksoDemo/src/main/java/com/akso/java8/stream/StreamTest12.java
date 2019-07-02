package com.akso.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest12 {

    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("hi", "hello", "你好"   );
        List<String> list2 = Arrays.asList("zhangsan", "lisi", "wangwu", "tianqi");

        List<String> res = list1.stream().flatMap(item -> list2.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList());
        res.stream().forEach(System.out::println);
    }
}
