package com.akso.algorithm.sort;

import org.junit.Test;

public class SelectionSort {
    int[] arr = {5, 3, 6, 8, 1, 7, 9, 4, 2, 0};

    @Test
    public void test1() {
        selecionSort(arr);
        for (int a : arr) {
            System.out.print(a);
        }
    }

    @Test
    public void test2() {
        selectionSort2(arr);
        for (int a : arr) {
            System.out.print(a);
        }
    }

    /**
     * 选择排序优化算法:　同时选择最大和最小值，　减少一半的循环
     *
     * 时间复杂度O(n^2), 空间复杂度O(1), 不稳定, 因为选择排序的时候，数组中相同值的数据位置有可能发生改变
     * @param arr
     */
    public void selectionSort2(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        int minPos = 0;
        int maxPos = 0;
        while(left < right) {
            minPos = left;
            maxPos = left;
            // 找出最小值　和　最大值的下标
            for(int j=left; j<= right; j++) {
                minPos = arr[j] < arr[minPos] ? j : minPos;
                maxPos = arr[j] > arr[maxPos] ? j : maxPos;
            }

            if(minPos != left) {
                swap(arr, minPos, left);
            }

            if(maxPos == left) { // 防止最大值出现在左边最小值存放的位置，　此刻最大值已被换到了minPos位置处，所以更新最大值的位置
                maxPos = minPos;
            }

            swap(arr, maxPos, right);
            left++;
            right--;
        }
    }

    /**
     * 选择排序算法: 时间复杂度O(n^2), 空间复杂度O(1), 不稳定, 因为选择排序的时候，数组中相同值的数据位置有可能发生改变
     * @param arr
     */
    public void selecionSort(int[] arr) {
        int minPos = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[j] < arr[minPos] ? j : minPos;
            }
            swap(arr, minPos, i);
        }
    }


    private static void swap(int[] arr, int minPos, int i) {
        int tmp = arr[i];
        arr[i] = arr[minPos];
        arr[minPos] = tmp;
    }
}
