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
     * 冒泡排序的第一种实现，　常规冒泡排序 -->通过对比相邻2个数，得到最大/最小数；
     */
    public void bubbleSort1(int[] arr) {
        for(int i=0; i< arr.length; i++) {
            for(int j=0; j < arr.length - 1; j++) {
                if(arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    /**
     * 冒泡排序的第二种实现, 在常规冒泡排序的基础上，跳过已排好的序列。
     */
    public void bubbleSort2(int[] arr) {
        int right = arr.length - 1;
        for (int i = 0; i < arr.length ; i++) {
            for(int j=0; j < right; j++) {
                if(arr[j] > arr[j + 1]) {
                    this.swap(arr, j , j+1);
                }
            }
            right--;
        }
    }

    /**
     * 冒泡排序的第三种实现
     * // 初始化冒泡排序的swap下标，每次比较值之前初始化为0，
     * 当一次循环比较结束后，还未发生swap，说明当前数组已存在顺序，无需再继续排序
     */
    public void bubbleSort3(int[] arr) {
        int right = arr.length -1 ;
        int m = 1;
        while(m>0) {
            m=0;
            for(int j=0; j<right; j++) {
                if(arr[j] > arr[j + 1]) {
                    swap(arr, j, j+1);
                    m = j;
                }
            }
            right--;
        }
    }

    /**
     * 冒泡排序的第四种实现, 即双向排序， 又称为鸡尾酒排序法
     *
     * 进行双向的循环，正向循环把最大元素移动到末尾，逆向循环把最小元素移动到最前
     *
     */
    public void bubbleSort4(int[] arr) {
        int left =0;
        int right = arr.length -1;
        while(left < right) {

            for (int i = 0; i < arr.length-1; i++) {
                if(arr[i] > arr[i + 1]) {
                    swap(arr, i, i+1);
                }
            }
            left++;

            for (int j = right; j >1 ; j--) {
                if(arr[j] < arr[j-1]) {
                    swap(arr, j, j-1);
                }
            }
            right--;
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
