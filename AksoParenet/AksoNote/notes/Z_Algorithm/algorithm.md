数据结构与算法

# 1. 基本概念

# 2. 十大经典排序算法

## 2.1 术语

- **稳定**：如果a原本在b前面，而a=b，排序之后a仍然在b的前面；

- **不稳定**：如果a原本在b的前面，而a=b，排序之后a可能会出现在b的后面；

- **内排序**：所有排序操作都在内存中完成；

- **外排序**：由于数据太大，因此把数据放在磁盘中，而排序通过磁盘和内存的数据传输才能进行；

- **时间复杂度：** 一个算法执行所耗费的时间。

- **空间复杂度**：运行完一个程序所需内存的大小。

  

## 2.2 算法总结

- n: 数据规模
- k: “桶”的个数
- In-place: 占用常数内存，不占用额外内存
- Out-place: 占用额外内存

![img](sort.jpg)



## 2.3 算法分类

![img](sortCategory.jpg)

## 2.4 排序及具体介绍

### 2.4.1 选择排序（Selection Sort)

选择排序是最简单，也是最没用的排序算法。时间复杂度为O(n^2), 

![img](selectionSort.gif)

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



### 2.4.2 插入排序(Insertion Sort)

插入排序：　每次从无序表中取出第一个元素，把它插入到有序表的合适位置，使有序表仍然有序。

第一趟比较前两个数，然后把第二个数按大小插入到有序表中； 第二趟把第三个数据与前两个数从前向后扫描，把第三个数按大小插入到有序表中；

依次进行下去，进行了(n-1)趟扫描以后就完成了整个排序过程。

插入排序的动图演示

![img](insertionSort.gif)



插入排序的实现及优化示例:



```java
package com.akso.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

public class InsertionSort {
    int[] arr = {5, 3, 6, 8, 1, 7, 9, 4, 2};

    @Test
    public void test() {
        insertionSort(arr);
        print(arr);
    }

    @Test
    public void test2() {
        insertionSort2(arr);
        print(arr);
    }

    /**
     * 插入排序：　时间复杂度 O(n^2)，　空间复杂度O(1)，　稳定
     * @param arr
     */
    public void insertionSort(int[] arr) {
        for(int i=arr.length-1; i > 0 ; i--) {
            for(int j=i-1; j >= 0; j--) {
                if(arr[i] < arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    /**
     * 优化后的插入排序，　减少多次交换，　只有在需要最后插入的位置进行插入值：　时间复杂度 O(n^2)，　空间复杂度O(1) 稳定
     * @param arr
     */
    public void insertionSort2(int[] arr) {
        for(int i=arr.length-1; i > 0 ; i--) {
            int tmp = arr[i];
            int k=-1;
            for(int j=i-1; j >= 0; j--) {
                if(arr[i] < arr[j]) {
                    arr[i] = arr[j];
                    k = j;
                }
            }
            if(k != -1) {
                arr[k] = tmp;
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j]= arr[i];
        arr[i] = temp;
    }

    public void print(int[] arr) {
        Arrays.stream(arr).forEach(System.out::print);
    }
}

```

### 2.4.3 冒泡排序

冒泡排序：　它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。

动图示例：

![img](bubbleSort.gif)



代码示例

