package com.akso.java9;

/**
 * String : JDK8 及之前： 底层使用char[]来存储， JDK9:底层使用byte[] + (encoding flag) 方式
 * StringBuffer: JDK8 及之前： 底层使用char[]来存储， JDK9:底层使用byte[] + (encoding flag) 方式
 * StringBuilder: JDK8 及之前： 底层使用char[]来存储， JDK9:底层使用byte[] + (encoding flag) 方式
 * String : 不可变的字符序列
 * StringBuffer: 可变的字符序列， 线程安全的， 效率低 (多线程情况下使用）
 * StringBuilder: 可变的字符序列， 线程不安全的， 效率高(jdk5.0) （单线程情况下使用）
 */
public class StringTest {


}
