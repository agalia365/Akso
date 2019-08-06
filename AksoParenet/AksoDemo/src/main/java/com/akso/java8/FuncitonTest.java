package com.akso.java8;

import org.junit.Test;

import java.util.function.Function;

public class FuncitonTest {

    @Test
    public void test() {
        System.out.println(compute(10, (x) -> x + x));
    }

    private int compute(int a, Function<Integer, Integer> fun) {
        return fun.apply(a);
    }
}
