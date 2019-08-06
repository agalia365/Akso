package com.akso.spring.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 创建一个spring 定义的工厂bean
 */
public class ColorFactoryBean implements FactoryBean<Color> {
    /**
     * 返回一个Color 对象
     *
     * @return
     * @throws Exception
     */
    @Override
    public Color getObject() throws Exception {
        System.out.println("getObject");
        return new Color();
    }

    /**
     * 控制是否是单例
     * true：这个bean 是单实例， 在容器中保存一份
     * false： 这是一个多实例， 每次获取都会创建一个实例
     *
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }
}
