package com.akso.java8;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Student> list1 = new ArrayList<>();

        list1.add(new Student("tom", 20, 20 ));
        list1.add(new Student("Lee", 30, 30 ));

//                Arrays.asList(new Student("tom", 20, 20 ),
//                new Student("Lee", 30, 30 ),
//                new Student("Jim", 40, 40 ));

        List<Student> list2 = new ArrayList<>();
        list2.addAll(list1);

        for(Student s: list2) {
            s = new Student(s.getName() + "---new", 50, 50);
        }
        list2.forEach(System.out::println);
        list1.forEach(System.out::println);

        System.out.println("---case 2-----------");


        List<String> list3 = new ArrayList<>();

        list3.add("list3");
        list3.add("list3");


        List<String> list4 = new ArrayList<>();
        list4.addAll(list3);

        for(String s: list4) {
            s = s + "-------" + "list4";
        }
        list3.forEach(System.out::println);
        list4.forEach(System.out::println);

        System.out.println("---case 3----------");


        List<String> list5 = new ArrayList<>();

        list5.add(new String("list5"));
        list5.add(new String("list5"));


        List<String> list6 = new ArrayList<>();
        list6.addAll(list5);

        for(int i =0 ; i< list6.size(); i++) {
            String s = list6.get(i);
            s = new String("change");
            System.out.println(s);
        }
        list5.forEach(System.out::println);
        list6.forEach(System.out::println);

        System.out.println("---------case 4");

        List<String> list7 = new ArrayList<>();
        list7.add("test");
        list7.add(new String("new String"));

        for(int i =0; i< list7.size(); i++) {
            String s = list7.get(i);

            list7.set(i, s);
        }
        list7.forEach(System.out::println);

    }
}
