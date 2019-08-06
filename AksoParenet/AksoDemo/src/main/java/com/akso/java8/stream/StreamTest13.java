package com.akso.java8.stream;

import com.akso.java8.methodRef.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest13 {

    public static void main(String[] args) {
        Student student1 = new Student("张三", 100, 20);
        Student student2 = new Student("lisi", 90, 32);
        Student student3 = new Student("zhangsan", 94, 25);
        Student student4 = new Student("zhangsan", 88, 22);
        Student student5 = new Student("tianqi", 88, 21);
        Student student6 = new Student("qianjiu", 60, 24);
        Student student7 = new Student("wangs", 90, 22);

        List<Student> list = Arrays.asList(student1, student2, student3, student4, student5, student6, student7);
        Map<String, List<Student>> map = list.stream().collect(Collectors.groupingBy(Student::getName));
        System.out.println(map);

        Map<Integer, List<Student>> scoreGroup = list.stream().collect(Collectors.groupingBy(Student::getScore));

        System.out.println(scoreGroup);

        Map<String, Long> countingGroup = list.stream().collect(Collectors.groupingBy(Student::getName, Collectors.counting()));
        System.out.println(countingGroup);

        Map<String, Double> aveGroup = list.stream().collect(Collectors.groupingBy(Student::getName, Collectors.averagingDouble(Student::getScore)));
        System.out.println(aveGroup);

        // 分区是分组的一种特殊表现形式
        Map<Boolean, List<Student>> partitionMap = list.stream().collect(Collectors.partitioningBy(student -> student.getScore() > 60));
        System.out.println(partitionMap);

        Map<Boolean, List<Student>> partitionMap2 = list.stream().collect(Collectors.partitioningBy(student -> student.getAge() > 30));
        System.out.println(partitionMap2);
    }


}