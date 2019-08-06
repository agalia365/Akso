package com.akso.java8.stream;

import com.akso.java8.Student;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class StreamAPITest3 {

    List<Student> students = Arrays.asList(
            new Student("zhangsan", 90, 20, Student.Status.BUSY),
            new Student("lisi", 80, 30, Student.Status.BUSY),
            new Student("wangwu", 70, 50, Student.Status.FREE),
            new Student("tianqi", 60, 80, Student.Status.VACATION),
            new Student("zhao", 50, 80, Student.Status.VACATION),
            new Student("qian", 60, 60, Student.Status.FREE)
    );

    /**
     * 查找与匹配
     * allMatch--检查是否匹配所有元素
     * anyMatch-- 检查是否至少匹配一个元素
     * noneMatch--检查是否没有匹配所有元素
     * findFirst--返回第一个元素
     * findAny--返回流中的任意一个元素
     * count--返回流中元素个数的总和
     * max--返回流中最大值
     * min--返回流中最小值
     */
    @Test
    public void test() {
        boolean allMatch = students.stream().allMatch(s -> s.getStatus().equals(Student.Status.BUSY));
        System.out.println(allMatch);
        System.out.println("-----------");
        boolean anyMatch = students.stream().anyMatch(s -> s.getStatus().equals(Student.Status.BUSY));
        System.out.println(anyMatch);
        System.out.println("----------------");
        boolean noneMatch = students.stream().noneMatch(s -> s.getStatus().equals(Student.Status.BUSY));
        System.out.println(noneMatch);
        System.out.println("----------");
        Optional<Student> optional = students.stream().sorted(Comparator.comparingInt(Student::getScore)).findFirst();
        optional.ifPresent(System.out::println);
        System.out.println("---------------");
        Optional<Student> op = students.parallelStream().filter(s1 -> s1.getStatus().equals(Student.Status.FREE)).findAny();
        op.ifPresent(System.out::println);

        long count = students.stream().count();
        System.out.println(count);
        System.out.println("--------------");
        Optional<Student> max = students.stream().max(Comparator.comparingInt(Student::getScore));
        max.ifPresent(System.out::println);
        System.out.println("-------------------");
        Optional<Integer> min = students.stream().map(Student::getScore).min(Integer::compare);
        min.ifPresent(System.out::println);
        System.out.println("-------------------");
    }


    /**
     * 归约reduce
     * reduce(T identity, BinaryOperator operator) / reduce(BinaryOperator operator)
     * --可以将流中元素反复结合起来得到一个新值
     */
    @Test
    public void test2() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        System.out.println("-------------");
        Optional<Integer> total = students.stream().map(s -> s.getScore()).reduce(Integer::sum);
        System.out.println(total.get());
        System.out.println("-------------");
    }

    /**
     * 收集
     * collect--将流转换为其他形式。 接受一个collector接口的实现， 用于给stream中元素做汇总的方法
     */
    @Test
    public void test3() {
        // 获取名字
        List<String> names = students.stream().map(s -> s.getName()).collect(Collectors.toList());
        System.out.println(names);

        //总数
        Long count = students.stream().collect(Collectors.counting());
        System.out.println(count);

        // 平均成绩
        Double avg = students.stream().collect(Collectors.averagingDouble(Student::getScore));
        System.out.println(avg);

        // 成绩总和
        Double total = students.stream().collect(Collectors.summingDouble(Student::getScore));
        System.out.println(total);

        // 最大成绩
        Optional<Student> max = students.stream().collect(Collectors.maxBy(Comparator.comparingInt(Student::getScore)));
        max.ifPresent(System.out::println);

        // 分组
        Map<Student.Status, List<Student>> map = students.stream().collect(Collectors.groupingBy(Student::getStatus));
        for (Map.Entry<Student.Status, List<Student>> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        Map<Student.Status, Map<String, List<Student>>> map2 = students.stream()
                .collect(Collectors.groupingBy(Student::getStatus, Collectors.groupingBy((Student s) -> {
                    if (s.getAge() <= 35) {
                        return "青年";
                    } else if (s.getAge() <= 50) {
                        return "中年";
                    } else {
                        return "老年";
                    }
                })));

        System.out.println(map2);

        Map<Boolean, List<Student>> partitioning = students.stream().collect(Collectors.partitioningBy((Student s) -> {
            if (s.getScore() < 60) {
                return false;
            } else {
                return true;
            }
        }));
        System.out.println(partitioning);

        // 组函数
        DoubleSummaryStatistics summaryStatistics = students.stream().collect(Collectors.summarizingDouble(Student::getScore));
        System.out.println(summaryStatistics.getMax());
        System.out.println(summaryStatistics.getAverage());
        System.out.println(summaryStatistics.getCount());
        System.out.println(summaryStatistics.getMin());
        System.out.println(summaryStatistics.getSum());
    }

    @Test
    public void testAPI() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.stream().map(x -> x * x).collect(Collectors.toList()).forEach(System.out::println);

        students.stream().map(x -> 1).reduce(0, (x, y) -> x + y);
    }
}
