package com.akso.java8.collector;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * 输入　：Set<String>
 * 输出　：　Ｍａｐ<String, String>
 *
 * 示例输入：　【"hello", "world", "hello word"】
 * 示例输出: [{hello, hello}, {world, world}, {hello word, hello word}]
 */
public class MySetCollector2<T> implements Collector<T, Map<T, T>, Map<T, T>> {


    @Override
    public Supplier<Map<T, T>> supplier() {
        System.out.println("supplier invoked!");
        return HashMap<T, T>::new;
    }

    @Override
    public BiConsumer<Map<T, T>, T> accumulator() {
        System.out.println("Accumulator invoked!");
        return (map, value) -> map.put(value, value);
    }

    @Override
    public BinaryOperator<Map<T, T>> combiner() {
        System.out.println("combiner invoked!");
        return (map1, map2) -> {
            map1.putAll(map2);
            return map1;
        };
    }

    @Override
    public Function<Map<T, T>, Map<T, T>> finisher() {
        System.out.println("finisher invoked");
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("Characteristics invoked!");
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED, Characteristics.IDENTITY_FINISH));
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "hello word", "hello");
        Map<String, String> map = list.stream().collect(new MySetCollector2<>());

        System.out.println(map);

    }
}
