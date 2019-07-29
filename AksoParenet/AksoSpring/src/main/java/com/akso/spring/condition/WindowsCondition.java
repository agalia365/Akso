package com.akso.spring.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class WindowsCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        ConfigurableListableBeanFactory factory = conditionContext.getBeanFactory();
        ClassLoader classLoader = conditionContext.getClassLoader();
        BeanDefinitionRegistry registry = conditionContext.getRegistry();

        Environment environment = conditionContext.getEnvironment();
        if(environment.getProperty("os.name").contains("Windows")) {
            return true;
        }
        return false;
    }
}
