package com.akso.java8;


import org.junit.Test;

import java.util.function.Function;

public class TestLambda {

    @Test
    public void test1() {
        Function<String, String> funciton = String::toUpperCase;
        System.out.println(funciton.getClass().getInterfaces()[0]);
        System.out.println();
    }


}
