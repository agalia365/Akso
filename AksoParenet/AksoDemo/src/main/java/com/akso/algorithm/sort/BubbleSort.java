package com.akso.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 冒泡排序：
 *
 * 时间复杂度O(n^2)
 * 空间复杂度O(1)
 * 稳定性: 稳定
 *
 * ４种实现方式
 *
 */
public class BubbleSort {
    int[] arr = {5, 3, 6, 8, 1, 7, 9, 4, 2, 0};

    @Test
    public void test1() {
        bubbleSort1(arr);
        print(arr);
    }

    @Test
    public void test2() {
        bubbleSort2(arr);
        print(arr);
    }

    @Test
    public void test3() {
        bubbleSort3(arr);
        print(arr);
    }

    @Test
    public void test4() {
        bubbleSort4(arr);
        print(arr);
    }

    /**
     * 冒泡排序的第一种实现，　常规冒泡排序
     */
    public void bubbleSort1(int[] arr) {

    }

    /**
     * 冒泡排序的第二种实现
     */
    public void bubbleSort2(int[] arr) {

    }

    /**
     * 冒泡排序的第三种实现
     */
    public void bubbleSort3(int[] arr) {

    }

    /**
     * 冒泡排序的第四种实现: 又称为鸡尾酒排序法
     */
    public void bubbleSort4(int[] arr) {

    }

    private void print(int[] arr) {
        Arrays.stream(arr).forEach(System.out::print);
    }
}
