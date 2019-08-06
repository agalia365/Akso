package com.akso.spring.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Dog {

    public Dog() {
        System.out.println("Dog created ...........");
    }

    /**
     * 对象创建并赋值之后调用
     */
    @PostConstruct
    public void init() {
        System.out.println("dog......PostConstruct........");
    }

    /**
     * 容器移除之前,执行清理工作
     */
    @PreDestroy
    public void destroy() {
        System.out.println("dog ......predestroy........");
    }
}
