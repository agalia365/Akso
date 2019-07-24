package com.akso.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

public class MergeSort {
    int[] arr = {5, 3, 6, 8, 1, 7, 9, 4, 2, 0};

    @Test
    public void test1() {
        mergeSort(arr);
        print(arr);
    }

    public void mergeSort(int[] arr) {


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
