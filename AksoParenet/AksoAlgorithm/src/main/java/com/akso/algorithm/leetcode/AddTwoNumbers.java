package com.akso.algorithm.leetcode;

import org.junit.Test;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = l1;
        ListNode second = l2;
        int addNum = 0;
        ListNode res = new ListNode(0);
        while (first != null) {
            if (first.next == null && second.next != null) {
                first.next = new ListNode(0);
            }
            if (second.next == null && first.next != null) {
                second.next = new ListNode(0);
            }
            int sumAll = addNum + first.val + second.val;
            first.val = sumAll % 10;
            addNum = sumAll / 10;
            if (first.next == null && second.next == null && addNum != 0) {
                first.next = new ListNode(0);
                second.next = new ListNode(0);
            }
            first = first.next;
            second = second.next;
        }
        return l1;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }


    }

    @Test
    public void test() {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);

        ListNode res = addTwoNumbers(l1, l2);

        System.out.println(res);
    }
}



