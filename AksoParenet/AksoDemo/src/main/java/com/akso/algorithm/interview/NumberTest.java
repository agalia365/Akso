package com.akso.algorithm.interview;

import org.junit.Test;

public class NumberTest {


    @Test
    public void test() {
        boolean b = test(-32);
        System.out.println(b);
    }

    /**
     * 如何判断一个数是２的ｎ　次方
     * @param num
     * @return
     */
    public boolean test(int num) {

        if(num == 1 || num == -1)  {
            return true;
        }
        if(num % 2 == 1) {
            return false;
        }
        num = num / 2;
        return test(num);
    }

}
