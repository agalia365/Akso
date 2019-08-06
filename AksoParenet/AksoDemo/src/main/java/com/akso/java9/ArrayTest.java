package com.akso.java9;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ArrayTest {

    List<Integer> container = new ArrayList<>();
    Integer[] source = new Integer[]{1, 2, 3};
    List<List<Integer>> result = new ArrayList<>();

    /**
     * Case 1: save the index and build the target from the source array by the saved index.
     */
    @Test
    public void testCase1() {
        for (int targetLength = 1; targetLength <= source.length; targetLength++) {
            findAllSubList(source, result, container, targetLength, 0);
        }
        System.out.println("---------------");
        System.out.println(result.toString());
    }

    /**
     * Case 2: save the object and build the target from the source array by deep clone based on the saved object
     */
    @Test
    public void testCase2() {
        for (int targetLength = 1; targetLength <= source.length; targetLength++) {
            findAllSubListCase2(source, result, container, targetLength, 0);
        }
        System.out.println("---------------");
        System.out.println(result.toString());
    }

    /**
     * Case 3:
     */
    @Test
    public void testCase3() {
        findAllSubListCase3(result, source, container, 1, 0);
        System.out.println("---------------");
        System.out.println(result.toString());
    }

    public void findAllSubList(Integer[] source, List<List<Integer>> result, List<Integer> container, int targetLength, int start) {
        for (int i = start; i < source.length; i++) {
            container.add(i);
            if (container.size() == targetLength) {
                buildTarget(result, source, container);
            } else {
                findAllSubList(source, result, container, targetLength, i + 1);
            }
            container.remove(container.size() - 1);
        }
    }

    public void findAllSubListCase2(Integer[] source, List<List<Integer>> result, List<Integer> container, int targetLength, int start) {
        for (int i = start; i < source.length; i++) {
            container.add(source[i]);
            if (container.size() == targetLength) {
                List<Integer> targetList = new ArrayList<>();
                for (Integer num : container) {
                    targetList.add(num);
                }
                result.add(targetList);
                System.out.println("targetList = " + targetList);
            } else {
                findAllSubListCase2(source, result, container, targetLength, i + 1);
            }
            container.remove(container.size() - 1);
        }
    }

    public void findAllSubListCase3(List<List<Integer>> result, Integer[] source, List<Integer> container, int targetLength, int start) {
//        for(int i=start; i< source.length; i++) {
//            for(int j = start; j < targetLength; j++) {
//                container.add(j);
//            }
//            if(targetLength < source.length) {
//                findAllSubListCase3(result, source, container, targetLength + 1, i);
//            } else {
//                buildTarget(result, source, container);
//            }
//            container.remove(container.size() -1);
////            container.clear();
//        }
    }

    private void buildTarget(List<List<Integer>> result, Integer[] source, List<Integer> container) {
        List<Integer> targetList = new ArrayList<>();
        for (int j = 0; j < container.size(); j++) {
            targetList.add(source[container.get(j)]);
        }
        result.add(targetList);
        System.out.println("targetList = " + targetList);
    }
}
