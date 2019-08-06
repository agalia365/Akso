package com.akso.java9;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TryTest {

    /**
     * case1 ： 传统的try catch 语句写法
     */
    @Test
    public void testTry1() {
        InputStreamReader reader = null;
        try {
            reader = new InputStreamReader(System.in);
            // 读取过程。。。。。。。
            reader.read();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Case 2： 在case1 的基础上的升级写法，不需要显实的处理资源的关闭
     * java8 要求资源对象的实例化， 必须放在try 的一对（）内完成
     * java9 中： 可以在try（）中调用已经实例化的资源对象
     */
    @Test
    public void testTry2() {
        try (InputStreamReader reader = new InputStreamReader(System.in)) {
            // 读取过程。。。。。。。
            reader.read();
        } catch (IOException e) {
            e.printStackTrace();
        } // JDK9 不再需要编写finally，即不再需要显式的关闭，但是前提是，要求
    }

    /**
     * JDK9 中的写法, 如下的写法在JDK9之前是不可以使用的
     */
    @Test
    public void testTry3() {
        InputStreamReader reader = new InputStreamReader(System.in);
        OutputStreamWriter writer = new OutputStreamWriter(System.out);
        try (reader; writer) { // 处理多个资源时，中间使用分号隔开
            // 此刻reader , writer 默认为final 的， 不可以对reader再次赋值
            // 读取过程。。。。。。。
            reader.read();
            writer.write(1);
        } catch (Exception e) {

        }
    }
}
