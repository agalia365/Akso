package com.akso.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateTest2 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2,3, 4, 5, 6, 7, 8 , 9, 10);

        PredicateTest2 test2 = new PredicateTest2();
        test2.conditionFilter(list, x -> x % 2 == 0);

        test2.conditionFilter(list, x -> x % 2 != 0);

        test2.conditionFilter(list, x -> x > 5);

        test2.conditionFilter(list, x -> x < 3);

        System.out.println("--------------");

        test2.conditionFilter(list, x -> true);


    }

    public void conditionFilter(List<Integer> list, Predicate<Integer> predicate) {
        List<Integer>  res = list.stream().filter(x -> predicate.test(x)).collect(Collectors.toList());
        res.stream().forEach(System.out::println);
    }
}
