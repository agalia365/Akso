package com.akso.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

public class InsertionSort {
    int[] arr = {5, 3, 6, 8, 1, 7, 9, 4, 2};

    @Test
    public void test() {
        insertionSort(arr);
        print(arr);
    }

    @Test
    public void test2() {
        insertionSort2(arr);
        print(arr);
    }

    /**
     * 插入排序：　时间复杂度 O(n^2)，　空间复杂度O(1)，　稳定
     * @param arr
     */
    public void insertionSort(int[] arr) {
        for(int i=arr.length-1; i > 0 ; i--) {
            for(int j=i-1; j >= 0; j--) {
                if(arr[i] < arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    /**
     * 优化后的插入排序，　减少多次交换，　只有在需要最后插入的位置进行插入值：　时间复杂度 O(n^2)，　空间复杂度O(1) 稳定
     * @param arr
     */
    public void insertionSort2(int[] arr) {
        for(int i=arr.length-1; i > 0 ; i--) {
            int tmp = arr[i];
            int k=-1;
            for(int j=i-1; j >= 0; j--) {
                if(arr[j+1] < arr[j]) {
                    arr[j+1] = arr[j];
                    k = j;
                }
            }
            if(k != -1) {
                arr[k] = tmp;
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j]= arr[i];
        arr[i] = temp;
    }

    public void print(int[] arr) {
        Arrays.stream(arr).forEach(System.out::print);
    }
}
