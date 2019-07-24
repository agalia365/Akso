package com.akso.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

public class MergeSort {
    int[] arr = {5, 3, 6, 8, 1, 7, 9, 4, 2, 0};

    @Test
    public void test1() {
        int[] result = mergeSort(arr);
        print(result);
    }

    public int[] mergeSort(int[] arr) {
        if(arr.length < 2) {
            return arr;
        }
        int mid = arr.length/2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    public int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int lt = 0;
        int r = 0;
        for(int i=0; i < result.length; i++) {
            if(lt >= left.length) {
                result[i] = right[r++];
            } else if(r >= right.length) {
                result[i] = left[lt++];
            } else if(left[lt] <= right[r] )  {
                result[i] = left[lt++];
            } else {
                result[i] = right[r++];
            }
        }
        return result;
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
