package com.akso.java9;

import org.junit.Test;

import java.util.*;

public class CollectionMapTest {

    /**
     * 创建一个只读特点的集合 JDK 8 及以前的做法 , case1
     */
    @Test
    public void test1() {
        List<String> list = Arrays.asList("hello", "hi", "how are you", "what is up", "how is going");
        // 调用Collections中的方法， 将list 变为只读
        List<String> newList = Collections.unmodifiableList(list);

//        newList.add("aaa"); // 不能执行， 会报java.lang.UnsupportedOperationException
        // 遍历 JDK8
        newList.forEach(System.out::println);
    }

    /**
     * 创建一个只读特点的集合 JDK 8 及以前的做法 , case2
     */
    @Test
    public void test2() {
        List<String> list = Collections.unmodifiableList(Arrays.asList("hello", "hi", "how are you"));
        list.forEach(System.out::println);

        Set<String> set = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("hello", "hi", "how are you")));
        set.forEach(System.out::println);

        Map<String, Integer> map = Collections.unmodifiableMap(new HashMap<>() {
            {
                put("Tom", 100);
                put("Lee", 120);
                put("MM", 98);
            }
        });
        map.forEach((k, v) -> System.out.println(k + ": " + v));
    }

    /**
     * JDK 9 中的升级写法
     */
    @Test
    public void test3() {
        List<String> list = List.of("hi ", "hello", "nihao");
        list.forEach(System.out::println);

        Set<String> set = Set.of("hi", "hello", "nihao");
        set.forEach(System.out::println);

        Map<String, Integer> map = Map.of("Tom", 18, "Lee", 20);
        map.forEach((k, v) -> System.out.println(k + ": " + v));

        Map<String, Integer> map2 = Map.ofEntries(Map.entry("Tom", 18), Map.entry("Lee", 22));
        map2.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
