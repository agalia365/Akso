package com.akso.java9;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class DiamondOperatorTest {

    @Test
    public void test() {
        diamondOperator();
    }
    public void diamondOperator() {
//        Set<String> set = new HashSet<>(); // 类型推断 JDK 9 之前的
        Set<String> set = new HashSet<>(){}; // JDK9 才可以编译通过， 创建一个继承于HashSet的匿名子类的对象。
        set.add("hello");
        set.add("hi");
        set.add("nihao");

        set.stream().forEach(System.out::println);
    }
}
