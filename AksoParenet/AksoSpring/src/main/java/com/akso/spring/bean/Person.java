package com.akso.spring.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 使用@Value 对属性赋值
 * 1. 可以使用基本数值 @Value("XXXXX")
 * 2. 可以使用SpEL表达式 @Value("#{100 -20 }")
 * 3. 可以使用配置文件中的值 @Value("${propertyKey}")
 */
@Component
public class Person {


    @Value("Lee")
    private String name;
    @Value("#{20-2}")
    private int age;
    @Value("#{2000000000-10000000}")
    private int salar;

    @Value("${person.nickName}")
    private String nickName;

    public Person() {
    }

    public Person(String name, int age, int salar) {
        this.name = name;
        this.age = age;
        this.salar = salar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salar=" + salar +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalar() {
        return salar;
    }

    public void setSalar(int salar) {
        this.salar = salar;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
