package com.akso.java8;

import java.util.function.Function;

public class FuncitonComposeAndThen {

    public static void main(String[] args) {
        FuncitonComposeAndThen test = new FuncitonComposeAndThen();
        System.out.println(test.compute(2, value -> value * 3, value -> value * value)); // 12
        System.out.println(test.compute2(2, value -> value * 3, value -> value * value)); // 36
    }

    public int compute(int a, Function<Integer, Integer> fun, Function<Integer, Integer> fun2) {
        return fun.compose(fun2).apply(a);
    }

    public int compute2(int a, Function<Integer, Integer> fun1, Function<Integer, Integer> fun2) {
        return fun1.andThen(fun2).apply(a);
    }
}
