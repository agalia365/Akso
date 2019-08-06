package com.akso.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

public class QuickSort {

    int[] arr = {5, 3, 6, 8, 1, 7, 9, 4, 2, 0};

    @Test
    public void test1() {
        quickSort(arr, 0, arr.length - 1);
        print(arr);
    }

    public void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            print(arr);
            System.out.println(pivot);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    public int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) { // 从右端开始扫描， 找出小于轴的值， 放到左边的位置
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) { // 从左端开始扫描， 找出大于轴的数据， 放到右边的位置
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
        arr[j] = arr[i];
        arr[i] = temp;
    }

    private void print(int[] arr) {
        Arrays.stream(arr).forEach(System.out::print);
        System.out.println();
    }


    /**
     * 快速排序的改进算法， 双轴快排， 即取2个轴，把数据分成3段进行排序
     */
    @Test
    public void test2() {

    }

    public void quickSort2(int[] arr, int left, int right) {
        if (left < right) {
            int[] pivots = partition2(arr, left, right);
            quickSort2(arr, 0, pivots[0] - 1);
            quickSort2(arr, pivots[0] + 1, pivots[1] - 1);
            quickSort2(arr, pivots[1] + 1, right);
        }
    }

    public int[] partition2(int[] arr, int left, int right) {
        int leftPivot = arr[left] < arr[left + 1] ? arr[left] : arr[left + 1];
        int middlePivot = arr[left] < arr[left + 1] ? arr[left + 1] : arr[left];
        while (left < right) {
            if (arr[left] < leftPivot) { // 从左端开始扫描, 满足条件再less 区
                left++;
            } else if (arr[left] < middlePivot) { // 满足条件， 放middle 区

            } else { // 其他情况放more 区
                right--;

            }
        }
        return null;
    }
}
