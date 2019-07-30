package com.akso.spring.condition;

import com.akso.spring.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class  MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * AnnotationMetadata 当前类的注解信息
     * beanDefinitionRegistry : beanDefinion 的注册类
     *
     * beanDefinitionRegistry.registerBeanDefinition 手动注册
     * @param annotationMetadata
     * @param beanDefinitionRegistry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        boolean definition = beanDefinitionRegistry.containsBeanDefinition("com.akso.spring.bean.Blue");
        boolean definition2 = beanDefinitionRegistry.containsBeanDefinition("com.akso.spring.bean.Red");
        if(definition && definition2) {
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);
            beanDefinitionRegistry.registerBeanDefinition("rainBow", rootBeanDefinition);
        }
    }
}
