数据结构与算法

１．　基本概念

２．　排序算法-10大排序算法及其复杂度和优缺点

２．１　选择排序

选择排序是最简单，也是最没用的排序算法。时间复杂度为O(n^2), 

稳定性－－不稳，　因为选择排序有可能改变相同元素的原始位置

举个例子，序列5 8 5 2 9， 我们知道第一遍选择第1个元素5会和2交换，那么原序列中2个5的相对前后顺序就被破坏了，所以选择排序不是一个稳定的排序算法

下面示例式选择排序的２个实现



```java
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
     * 时间复杂度O(n^2),空间复杂度O(1),不稳定, 因为选择排序的时候，数组中相同值的数据位置有可能发生改变
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

```

