package com.akso.java8.methodRef;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceTest {

    public String getString(Supplier<String> supplier) {
        return supplier.get() + "test";
    }

    public String getString2(String str, Function<String, String> fun) {
        return fun.apply(str);
    }

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

        System.out.println("--------------");

        list.sort((x1, x2) -> x1.compareByScore(x2));
        list.sort(Student::compareByScore);


        List<String> data = Arrays.asList("adfaaaa", "abbbb", "dcccc", "tcdddd");

        data.sort(String::compareToIgnoreCase);

        data.forEach(System.out::println);

        MethodReferenceTest test = new MethodReferenceTest();
        System.out.println(test.getString(String::new));

        System.out.println(test.getString2("hello", String::new));
    }
}
