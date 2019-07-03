package com.akso.java8.stream2;

import com.akso.java8.Student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest1 {
    public static void main(String[] args) {
        Student student1 = new Student("zhangsan" , 100, 20);
        Student student2 = new Student("lisi" , 90, 32);
        Student student3 = new Student("zhangsan" , 94, 25);
        Student student4 = new Student("zhangsan" , 88, 22);
        Student student5 = new Student("tianqi" , 88, 21);
        Student student6 = new Student("qianjiu" , 60, 24);
        Student student7 = new Student("wangs" , 90, 22);

        List<Student> list = Arrays.asList(student1, student2, student3, student4, student5, student6, student7);

        List<Student> list2 = list.stream().collect(Collectors.toList());

        System.out.println("--------------");
        list2.forEach(System.out::println);

        System.out.println("-------------");

        System.out.println("count: " + list.stream().collect(Collectors.counting()));
        System.out.println("count: " + list.stream().count());
    }
}
