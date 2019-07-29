package com.akso.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

public class QuickSort {

    int[] arr = {5, 3, 6, 8, 1, 7, 9, 4, 2, 0};

    @Test
    public void test1() {
        quickSort(arr);
        print(arr);
    }

    public int[] quickSort(int[] arr) {
        if(arr.length == 1) {
            return arr;
        }
        int pivot = arr.length/2;
        int left = 0;
        int right = arr.length -1;
        while(left < right) {
            while(arr[left] <= arr[pivot]) {
                left ++;
            }
            while(arr[right] >= arr[pivot]) {
                right --;
            }
            if(left < right) {
                if(left < pivot && pivot > right) {
                    swap(arr, left, right);
                }

            }
        }
        return contact(quickSort(Arrays.copyOfRange(arr, 0, pivot)), quickSort(Arrays.copyOfRange(arr, pivot, arr.length)));
    }

    public int[] contact(int[] arr1, int[] arr2) {
        int[] c = new int[arr1.length];
        System.arraycopy(arr1, 0, c, 0, arr1.length);
        System.arraycopy(arr2, 0, c, 0, arr2.length);
        return c;
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
