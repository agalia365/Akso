package com.akso.java8.lambda;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class ConsumerTest {

    public void test(Consumer<Integer> consumer) {
        consumer.accept(100);
    }

    public static void main(String[] args) {
        ConsumerTest test = new ConsumerTest();

        Consumer<Integer> consumer = x -> System.out.println(x);
        IntConsumer intConsumer = x -> System.out.println(x);

        test.test(x -> System.out.println(x));


        test.test(consumer);    // 面向对象方式

        test.test(consumer::accept);    // 函数式方式
        test.test(intConsumer::accept);     // 函数式方式

    }
}
