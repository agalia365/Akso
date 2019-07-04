package com.akso.java8.collector;

import java.util.Map;
import java.util.Set;
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
        return null;
    }

    @Override
    public BiConsumer<Map<T, T>, T> accumulator() {
        return null;
    }

    @Override
    public BinaryOperator<Map<T, T>> combiner() {
        return null;
    }

    @Override
    public Function<Map<T, T>, Map<T, T>> finisher() {
        return null;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return null;
    }
}
