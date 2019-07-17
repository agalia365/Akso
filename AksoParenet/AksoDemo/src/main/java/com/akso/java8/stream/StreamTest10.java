package com.akso.java8.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest10 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hell", "world", "hello world");

//        list.stream().mapToInt(x -> x.length()).filter(x -> x == 5).findFirst().ifPresent(System.out::println);

        list.stream().mapToInt(x -> {
            System.out.println(x);
            return x.length();
        }).filter( x -> x== 5).findFirst().ifPresent(System.out::println);
        /**
         * hell
         * world
         * 5
         */
    }

    @Test
    public void test() {
        Stream.generate(() -> 1).limit(10).forEach(System.out::println);
        Stream.iterate(0, (x) -> x + 1);
    }

    @Test
    public void test2() {
//        IntStream.iterate(0, i -> (i + 1) % 2).distinct().limit(6).forEach(System.out::println);
        // 无限流，因为先做了distinct(), 得到了1, 0，　limit无法终止操作


//        IntStream.iterate(0, i -> (i + 1) % 2).limit(6).distinct().forEach(System.out::println);
        // 先得到6个元素值，　然后进行distinct操作，得到1, 0


        IntStream.iterate(0, i -> i + 1).limit(10).limit(15).forEach(System.out::println);
        // 输出　0-9 , 10个数字

        IntStream.iterate(0, i -> i + 1).limit(10).limit(15).limit(3).forEach(System.out::println);
        // 输出 0,1,2 共3个数字
    }
}
