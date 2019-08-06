package com.akso.java9;

/**
 * 1.
 * 类： 人
 * 接口： 兽 --》 半兽人
 * <p>
 * 2. 面试题： 抽象类 和接口的异同？
 * a. 二者的定义：声明的方式， 内部结构（jdk7， jdk8， jdk9）
 * b. 共同点： 不能实例化； 以多态的方式使用
 * c. 不同点： 单继承， 多实现
 */
public interface MyInterface {
    // jdk7 : 只能声明全局常量(public static final )和抽象方法（abstract)
    public static final String C_VALUE = "123";

    public void method1();

    // jdk8 : 声明静态方法和默认方法
    public static void method2() {
        System.out.println("method2");
    }

    default void method3() {
        System.out.println("default method : method3");
    }

    // jdk 9 : 声明私有方法
    private void method4() {
        System.out.println("private method in JDK 9.");
    }

}
