package com.akso.java8.collector;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class MyMapCollector<T> implements Collector<T, Set<T>, Map<T, T>> {

    /**
     * *     A a1 = supplier.get();
     * *     accumulator.accept(a1, t1);
     * *     accumulator.accept(a1, t2);
     * *     R r1 = finisher.apply(a1);  // result without splitting
     * *
     * *     A a2 = supplier.get();
     * *     accumulator.accept(a2, t1);
     * *     A a3 = supplier.get();
     * *     accumulator.accept(a3, t2);
     * *     R r2 = finisher.apply(combiner.apply(a2, a3));  // result with splitting
     */
    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("supplier invoked!");
        return HashSet::new;
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("Accumulator invoked!");

        return (set, item) -> {
            System.out.println("accumulator: ->" + set + Thread.currentThread().toString());
            set.add(item);
        };
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner invoked!");
        return (set1, set2) -> {
            System.out.println("combiner: -->" + set1 + Thread.currentThread().toString());
            set1.addAll(set2);
            return set1;
        };
    }

    @Override
    public Function<Set<T>, Map<T, T>> finisher() {
        System.out.println("Finisher invoked");
        return (set) -> {
            Map<T, T> map = new HashMap<>();
            set.stream().forEach((item) -> map.put(item, item));
            return map;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("Characteristics invoked");
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED, Characteristics.CONCURRENT));
    }

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < 10; i++) {
            List<String> list = Arrays.asList("hello", "world", "hello word", "hello", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q");
            Map<String, String> map = list.parallelStream().unordered().collect(new MyMapCollector<>());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String k = entry.getKey();
                String v = entry.getValue();
                System.out.println("key: " + k + "value: " + v);
            }
            System.out.println("----------");
            System.out.println(map);
        }
    }
}
