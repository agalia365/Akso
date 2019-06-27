package com.akso.java8.methodRef;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceTest {

    public static void main(String[] args) {
        Student s1 = new Student("zhangsan", 50);
        Student s2 = new Student("lisi", 60);
        Student s3 = new Student("wangwu", 70);
        Student s4 = new Student("zhaoliu", 80);
        Student s5 = new Student("tianqi", 90);

        List<Student> list = Arrays.asList(s1, s2, s3, s4, s5);

        list.sort((x1, x2) -> Student.compareStudentByScore(x1, x2));
        list.forEach(System.out::println);

        System.out.println("------------------");
        list.sort(Student::compareStudentByScore);

        list.forEach(System.out::println);

        StudentComparator sc = new StudentComparator();
        list.sort(sc::compareStudentByName);
        list.forEach(System.out::println);
        list.sort(sc::compareStudentByScore);
        list.forEach(System.out::println);


    }
}
