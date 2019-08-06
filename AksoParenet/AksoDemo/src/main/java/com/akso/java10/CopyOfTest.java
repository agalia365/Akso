package com.akso.java10;

import java.util.*;

public class CopyOfTest {
    public static void main(String[] args) {
        var list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        var list2 = List.copyOf(list);
        list2.stream().forEach(System.out::println);

        var set = new HashSet<>();
        set.add("a");
        set.add("b");

        var set2 = Set.copyOf(set);
        System.out.println(set2);

        var map = new HashMap<>();
        map.put("a", "1");
        map.put("b", "2");

        var map2 = Map.copyOf(map);
        System.out.println(map2);
    }
}
