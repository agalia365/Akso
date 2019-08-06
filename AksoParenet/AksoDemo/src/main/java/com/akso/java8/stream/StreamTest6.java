package com.akso.java8.stream;

import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

public class StreamTest6 {
    public static void main(String[] args) {
        Stream stream = Stream.generate(UUID.randomUUID()::toString);
        stream.findFirst().ifPresent(System.out::println);

        Stream stream1 = Stream.empty();
        System.out.println(stream1.findFirst().orElse("test"));

        Stream stream2 = Stream.iterate(1, item -> item + 2).limit(6);
        // 1, 3, 5, 7, 9
        // 3, 5, 7, 9
        // 6, 10 , 14, 18
        // 14, 18
        // sum = 32

        Optional<Integer> optional = stream2.filter(x -> (Integer) x > 2).map(x -> (Integer) x * 2).skip(2).limit(2).reduce((a, b) -> Integer.sum((Integer) a, (Integer) b));
        optional.ifPresent(System.out::println);

        Stream<Integer> stream3 = Stream.iterate(1, item -> item + 2).limit(6);
        stream3.filter(x -> x > 2).mapToInt(x -> x * 2).skip(2).limit(2).reduce(Integer::sum);

        Stream<Integer> stream4 = Stream.iterate(1, item -> item + 2).limit(6);
        IntSummaryStatistics s = stream4.filter(x -> x > 2).mapToInt(x -> x * 2).skip(2).limit(2).summaryStatistics();
        System.out.println(Integer.sum(s.getMax(), s.getMax()));
    }
}
