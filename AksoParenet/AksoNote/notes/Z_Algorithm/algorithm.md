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

![img](sortCategory.png)

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

冒泡排序：　冒泡排序是一种简单的排序算法, 它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。

动图示例：

![img](bubbleSort.gif)



代码示例

```java
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
                    swap(arr, j , j+1);
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
```

### 2.4.4  希尔排序（Shell Sort）

希尔排序是希尔（Donald Shell）于1959年提出的一种排序算法。希尔排序也是一种插入排序，它是简单插入排序经过改进之后的一个更高效的版本，也称为缩小增量排序，同时该算法是冲破O(n2）的第一批算法之一。它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序。

希尔排序是把记录按下表的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止。

**算法描述**

先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，具体算法描述：

- 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
- 按增量序列个数k，对序列进行k 趟排序；
- 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。

**算法分析**

最佳情况：T(n) = O(nlog2 n)  最坏情况：T(n) = O(nlog2 n)  平均情况：T(n) =O(nlog2n)　

希尔排序的ｇａｐ　除了采用每次折半的算法外还可以采用Knuth算法，即

ｈ= 1;

h = 3*h + 1;

示例：

int h =　１；

while(h<array.length/3) {

​		h = h*3 + 1;

}

for(int gap = h; gap > 0; gap = (gap - 1 )/3) {

​		........

}



```java
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
        int gap = arr.length/2;
        while(gap > 0) {
            for (int i = gap; i < arr.length ; i++) {
                int preIndex = i - gap;
                int tmp = arr[i];
                int pos = -1;
                while(preIndex >= 0 && tmp < arr[preIndex]) {
                    arr[preIndex+gap] = arr[preIndex];
                    pos = preIndex;
                    preIndex = preIndex - gap;
                }
                if(pos != -1) {
                    arr[pos] = tmp;
                }
            }
            gap = gap / 2;
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

```

### 2.5.5 归并排序（Merge Sort)

和选择排序一样，归并排序的性能不受输入数据的影响，但表现比选择排序好的多，因为始终都是O(n log n）的时间复杂度。代价是需要额外的内存空间。

归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。归并排序是一种稳定的排序方法。将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。

**算法描述**

把长度为n的输入序列分成两个长度为n/2的子序列；对这两个子序列分别采用归并排序；将两个排序好的子序列合并成一个最终的排序序列。

**算法分析**

最佳情况：T(n) = O(n)  最差情况：T(n) = O(nlogn)  平均情况：T(n) = O(nlogn)

![img](/home/leo/IdeaProjects/Akso/AksoParenet/AksoNote/notes/Z_Algorithm/mergerSort.gif)