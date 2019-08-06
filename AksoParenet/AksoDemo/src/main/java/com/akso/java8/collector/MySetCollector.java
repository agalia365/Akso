package com.akso.java8.collector;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class MySetCollector<T> implements Collector<T, Set<T>, Set<T>> {

    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("Supplier invoked!");

        return HashSet<T>::new;
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("Accumulator invoked!");
//        return (e, e2) -> e.add(e2);
        return Set<T>::add;
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner invoked");
        return (set1, set2) -> {
            set1.addAll(set2);
            return set1;
        };
    }

    @Override
    public Function<Set<T>, Set<T>> finisher() {
        System.out.println("Finisher invoked!");

//        return t -> t;
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("Characteristics invoked!");

        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH, Characteristics.UNORDERED));

    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "welcome", "hello");
        Set<String> set = list.stream().collect(new MySetCollector<>());

        set.forEach(System.out::println);

        Set<String> set2 = list.stream().collect(new MySetCollector<>());


        set2.forEach(System.out::println);

    }
}
