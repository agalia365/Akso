package com.akso.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamGenerate {

    public static void main(String[] args) {

        // 通过Stream 的静态方法
        Stream stream = Stream.of("hello", "world", "how", "are you");

        // 通过数组获取流
        String[] data = new String[]{"aaaaa", "bb bb", "ccccc", "dddd", "eeee"};
        Stream stream1 = Arrays.stream(data);

        // 通过List 获取流
        List<String> list = Arrays.asList("aaaaa", "bb bb", "ccccc", "dddd", "eeee");
        Stream stream2 = list.stream();

        // generator generator方法，返回一个无限长度的Stream,其元素由Supplier接口的提供。在Supplier是一个函数接口，只封装了一个get()方法，其用来返回任何泛型的值，该结果在不同的时间内，返回的可能相同也可能不相同，没有特殊的要求。
        Stream.generate(() -> 1).limit(10).forEach(System.out::println);

        // empty方法返回一个空的顺序Stream，该Stream里面不包含元素项。
        Stream.empty();
    }
}
