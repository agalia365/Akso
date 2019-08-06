package com.akso.java8.annotation;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * 重复注解和类型注解
 */
public class AnnotationTest {

    @MyAnnotation("hello")
    @MyAnnotation("world")
    public void show(@MyAnnotation("abc") String str) {

    }

    @Test
    public void test() throws NoSuchMethodException {
        Class<AnnotationTest> clazz = AnnotationTest.class;
        Method m1 = clazz.getMethod("show", String.class);

        MyAnnotation[] myAnnotations = m1.getAnnotationsByType(MyAnnotation.class);
        System.out.println("-----------");
        for (MyAnnotation annotation : myAnnotations) {
            System.out.println(annotation.value());
        }
    }
}
