package com.akso.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class StreamTest9 {
    public static void main(String[] args) {
        List<String> uuid = new ArrayList<>(5000000);
        for (int i = 0; i < 5000000; i++) {
            uuid.add(UUID.randomUUID().toString());
        }
        System.out.println("开始排序");

        long startDate = System.nanoTime();

//        uuid.stream().sorted().count();
        uuid.parallelStream().sorted();

        long endDate = System.nanoTime();

        long cost = TimeUnit.NANOSECONDS.toMillis(endDate - startDate);
        System.out.println("耗时: " + cost);
    }
}
