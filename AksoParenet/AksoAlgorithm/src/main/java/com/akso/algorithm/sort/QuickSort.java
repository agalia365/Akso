package com.akso.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

public class QuickSort {

    int[] arr = {5, 3, 6, 8, 1, 7, 9, 4, 2, 0};

    @Test
    public void test1() {
        quickSort(arr, 0, arr.length -1);
        print(arr);
    }

    public void quickSort(int[] arr, int left, int right) {
        if(left < right) {
            int pivot = partition(arr, left, right);
            print(arr);
        System.out.println(pivot);
            quickSort(arr, left, pivot-1);
            quickSort(arr, pivot+1, right);
        }
    }

    public int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        while(left < right) {

            while(left < right && arr[right] >= pivot) { // 从右端开始扫描， 找出小于轴的值， 放到左边的位置
                right--;
            }
            arr[left] = arr[right];

            while(left < right && arr[left] <= pivot) { // 从左端开始扫描， 找出大于轴的数据， 放到右边的位置
                left++;
            }
            arr[right] = arr[left];
        }
        System.out.println("left===>" + left + ", right ===>" + right);
        arr[left] = pivot; // 把轴的数据放到对应的轴位置
        return left;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j]= arr[i];
        arr[i] = temp;
    }
    private void print(int[] arr) {
        Arrays.stream(arr).forEach(System.out::print);
        System.out.println();
    }
}
