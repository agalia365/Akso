package com.akso.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest1 {

    public static void main(String[] args) {

        // 通过Stream 的静态方法
        Stream stream = Stream.of("hello", "world", "how", "are you");

        // 通过数组获取流
        String[] data = new String[]{"aaaaa", "bb bb", "ccccc", "dddd", "eeee"};
        Stream stream1 = Arrays.stream(data);

        // 通过List 获取流
        List<String> list = Arrays.asList("aaaaa", "bb bb", "ccccc", "dddd", "eeee");
        Stream stream2 = list.stream();


    }
}
