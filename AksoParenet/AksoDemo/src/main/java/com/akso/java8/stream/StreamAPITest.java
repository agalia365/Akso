package com.akso.java8.stream;

import com.akso.java8.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPITest {
    List<Student> students = Arrays.asList(
            new Student("zhangsan", 90, 20),
            new Student("lisi", 80, 30),
            new Student("wangwu", 70, 50),
            new Student("tianqi", 60, 80),
            new Student("zhao", 50, 80),
            new Student("qian", 60, 60),
            new Student("qian", 60, 60),
            new Student("zhou", 80, 80)
    );

    /**
     * 筛选与切片
     * filter --接收Lambda, 从流中排除某些元素
     * limit -- 截断流， 使其元素不超过给定数量
     * skip（n）-- 跳过元素， 返回一个扔掉了前n个元素的流。 若流中元素不足n 个，则返回一个空流。 与limit（n）互补
     * distinct--筛选 ， 通过流生成的hashcode（） 和equals（）去除重复元素
     */
    @Test
    public void test1() {
        students.stream().filter(s -> s.getAge() > 35).forEach(System.out::println); // 筛选年龄大于35的
        System.out.println("-----");
        students.stream().limit(3).forEach(System.out::println); // 取前3个元素
        System.out.println("-----");
        students.stream().skip(3).forEach(System.out::println); // 跳过前3个元素
        System.out.println("-----");
        students.stream().distinct().forEach(System.out::println); // 剔除重复项
    }

    @Test
    public void test2() {
        //内部迭代： 迭代操作由Stream API 完成
        // 中间操作: 不会执行任何操作
        Stream<Student> stream = students.stream().filter((e) -> {
            System.out.println("Stream API 的中间操作");
            return e.getAge() > 35;
        });
        // 终止操作: 一次性执行全部内容, 即惰性求值
        stream.forEach(System.out::println);
    }

    @Test
    public void test3() {
        // 外部迭代
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    /**
     * 映射
     * map--接受Lambda, 将元素转换成其他形式或提取信息.接受一个函数作为参数， 该函数会被应用到每个元素上， 并将其映射成一个新的元素。
     * flatMap--接收一个函数作为参数，将流中的每个值都换成另一个流， 然后把所有流连接成一个流
     */
    @Test
    public void test5() {
        List<String> list = Arrays.asList("aaaa", "bbb", "ccc", "ddd", "eeee", "fff", "gggg", "hhhh");
        list.stream().map((str) -> str.toUpperCase()).forEach(System.out::println);
        System.out.println("------------------");
        Stream<Stream<Character>> stream = list.stream().map(StreamAPITest::filterCharacter);

        Stream<Character> stream1 = list.stream().flatMap(StreamAPITest::filterCharacter);
    }

    public static Stream<Character> filterCharacter(String str) {
        List<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    /**
     * 排序
     * sorted() -- 自然排序Comparable
     * sorted(Comparator com) -- 定制排序
     */
    @Test
    public void test6() {
        List<String> list = Arrays.asList("hello", "world", "hi", "welcome", "");
        list.stream().sorted().forEach(System.out::println);

        System.out.println("--------------");
        students.stream().sorted((s1, s2) -> {
            if (s1.getAge() == s2.getAge()) {
                return s1.getName().compareTo(s2.getName());
            } else {
                return s1.getAge() - s2.getAge();
            }
        });
    }

}
