package com.akso.java8;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class BinaryOperatorTest {

    public static void main(String[] args) {

        BinaryOperatorTest test = new BinaryOperatorTest();

        test.calculate(10, 20, (x, y) -> x + y);

        System.out.println("--------------");

        String word = test.getShort("AAAAA", "BBBBB", Comparator.comparingInt(String::length));
        System.out.println(word);

        System.out.println(test.getShort("hello123", "world", Comparator.naturalOrder()));

    }

    public void calculate(Integer a, Integer b, BinaryOperator<Integer> binaryOperator) {
        Integer res = binaryOperator.apply(a, b);
        System.out.println(res);
    }


    public String getShort(String a, String b, Comparator<String> comparator) {
        return BinaryOperator.minBy(comparator).apply(a, b);
    }

}
