package com.akso.java10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * JDK 10 新特性:
 *
 * 局部变量类型推断
 */
public class VarTest {

    /**
     * 该特性注意点：
     * 1. 只针对局部变量
     * 2. var 是保留类型不是关键字，意味着我们还可以用var来定义变量名和方法名
     * 3. var 不允许赋值null
     * @param args
     */
    public static void main(String[] args) {
        var i = 10;
        var str = "abc";
        var list = new ArrayList<>();
        list.add("tom");
        var set = new HashSet<>();
        set.add("Jim");
        var map = new HashMap<String, String>();
        map.put("name", "Lee");

        System.out.println(i);
        System.out.println(str);
        System.out.println(list);
        System.out.println(set);
        map.forEach((k, v) -> System.out.println(k + " -" + v));

        for(Map.Entry<String, String> entry : map.entrySet()) {
            var key = entry.getKey();
            var value = entry.getValue();
            System.out.println(key + "-" + value);
        }
    }
}
