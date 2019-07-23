package com.akso.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

public class ShellSort {
    int[] arr = {5, 3, 6, 8, 1, 7, 9, 4, 2, 0};

    @Test
    public void test1() {
        shellsort(arr);
        print(arr);
    }

    public void shellsort(int[] arr) {
        int gap = 4;

        for (int i = arr.length-gap; i > 0 ; i--) {
            for (int j = i-gap; j >=0 ; j--) {
                if(arr[i] < arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j]= arr[i];
        arr[i] = temp;
    }

    private void print(int[] arr) {
        Arrays.stream(arr).forEach(System.out::print);
    }
}
