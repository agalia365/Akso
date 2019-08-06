package com.akso.algorithm.leetcode;

import org.junit.Test;

public class TwoPowerOfN {


    @Test
    public void test() {
        boolean b = test(-32);
        System.out.println(b);
    }

    @Test
    public void test2() {
        boolean b = test2(-32);
        System.out.println(b);
    }

    /**
     * 如何判断一个数是２的ｎ　次方
     *
     * @param num
     * @return
     */
    public boolean test(int num) {

        if (num == 1 || num == -1) {
            return true;
        }
        if (num % 2 == 1) {
            return false;
        }
        num = num / 2;
        return test(num);
    }

    /**
     * 通过位的与运算来判断，２的ｎ　次方的都是１００００００，　２的ｎ次方－１都是０１１１１１１１，
     * ２者与运算后为０的话，则表示该数为２的ｎ次方
     *
     * @param
     * @return
     */
    public boolean test2(int m) {
        if (m < 0) {
            m = -m;
        }
        return (m & (m - 1)) == 0;
    }

}
