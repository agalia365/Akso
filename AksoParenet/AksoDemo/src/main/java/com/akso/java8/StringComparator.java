package com.akso.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringComparator {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("张三", "王五", "李四", "田七");

        Collections.sort(names, Comparator.naturalOrder());
        System.out.println(names);

        Collections.sort(names, Comparator.reverseOrder());
        System.out.println(names);
    }
}
