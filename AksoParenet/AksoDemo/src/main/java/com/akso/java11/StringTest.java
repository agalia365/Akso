package com.akso.java11;

import org.junit.Test;

public class StringTest {
    @Test
    public void testStringNewAPI() {
        /**
         * isBlank 判断字符是否为空
         */
        System.out.println("   \t \n    ".isBlank());

        /**
         * strip 去除首位空格
         */
        System.out.println("------" + "   a\t \nb    ".strip() + "----");
        System.out.println("------" + "   a\t \nb    ".trim() + "----");

        // stripTrailing去除尾部空格
        System.out.println("------" + "   a\t \nb    ".stripTrailing() + "----");
        // stripLeading 去除头部空格
        System.out.println("------" + "   a\t \nb    ".stripLeading() + "----");

        String str = "abc";
        String str2 = str.repeat(5);
        System.out.println(str2);

        var str3 = "abc\ndfas\n";
        System.out.println(str3.lines().count());
    }
}
