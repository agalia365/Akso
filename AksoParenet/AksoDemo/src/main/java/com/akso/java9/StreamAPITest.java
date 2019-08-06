package com.akso.java9;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPITest {

    // JDK 9 针对stream 新加了4个方法

    /**
     * 1. takewhile()的使用
     * 用于从 Stream 中获取一部分数据，接收一个 Predicate 来进行选择。
     * 在有序的 Stream 中，takeWhile 返回从开头开始的尽量多的元素。
     */
    @Test
    public void test() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> stream = list.stream();
        stream.takeWhile(x -> x < 5).forEach(System.out::println);
    }

    /**
     * 2. dropWhile()的使用：
     * dropWhile 的行为与 takeWhile 相反，返回剩余的元素。相当于takewhile的补集
     */
    @Test
    public void testDropWhile() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> stream = list.stream();
        stream.dropWhile(x -> x < 5).forEach(System.out::println);
    }

    /**
     * 3. ofNullable()的使用
     * Java 8 中 Stream 不能完全为null，否则会报空指针异常。
     * 而 Java 9 中的ofNullable 方法允许我们创建一个单元素 Stream，
     * 可以包含一个非空元素，也可以创建一个空 Stream。
     */
    @Test
    public void testOfNullable() {
        Stream<Integer> stream1 = Stream.of(1, 2, 3, null);
        stream1.forEach(System.out::println);

        // 如果只有一个元素且为null ， 那么会报nullpointexception错误
//        Stream<Object> stream2 = Stream.of(null);

        Stream<Object> stream3 = Stream.ofNullable(null);
        System.out.println(stream3.count()); // 返回结果是0， null不被认为是元素，所以返回为0
    }

    /**
     * 4. iterator()重载的使用：
     */
    @Test
    public void testIterator() {
        // 复习 Stream的实例化
        /**
         * a. 通过集合的stream（）方法
         * b. 通过数组的工具类 Arrays
         * c. Stream中的静态方法Of()
         * d. iterator
         */

        // 原来的控制终止方式：
        Stream.iterate(0, x -> x + 1).limit(10).forEach(System.out::println);

        // 现在的终止方式：
        Stream.iterate(0, i -> i < 10, x -> x + 1).forEach(System.out::println);
    }
}
