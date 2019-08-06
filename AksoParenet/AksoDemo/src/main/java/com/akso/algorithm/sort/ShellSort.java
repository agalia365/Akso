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
        int gap = arr.length / 2;
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int preIndex = i - gap;
                int tmp = arr[i];
                int pos = -1;
                while (preIndex >= 0 && tmp < arr[preIndex]) {
                    arr[preIndex + gap] = arr[preIndex];
                    pos = preIndex;
                    preIndex = preIndex - gap;
                }
                if (pos != -1) {
                    arr[pos] = tmp;
                }
            }
            gap = gap / 2;
        }

    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    private void print(int[] arr) {
        Arrays.stream(arr).forEach(System.out::print);
    }
}
