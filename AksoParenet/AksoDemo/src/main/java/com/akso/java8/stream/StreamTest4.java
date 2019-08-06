package com.akso.java8.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest4 {

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("hello", "world", "hello world");

//        String[] stringArray = stream.toArray(l -> new String[l]);

//        String[] stringArray2 = stream.toArray(String[]::new);

//        Arrays.stream(stringArray).forEach(System.out::println);

//        Arrays.stream(stringArray2).forEach(System.out::println);

//        List<String> list = stream.collect(() -> new ArrayList<>(), (theList, item) -> theList.add(item),
//                (theList1, theList2) -> theList1.addAll(theList2)) ;

//        List<String> list = stream.collect(ArrayList::new, ArrayList::add,
//                ArrayList::addAll) ;
////        stream.collect(Collectors.toCollection(LinkedList::new));
//        list.forEach(System.out::println);

        List<String> list = stream.collect(Collectors.toCollection(LinkedList::new));

    }
}
