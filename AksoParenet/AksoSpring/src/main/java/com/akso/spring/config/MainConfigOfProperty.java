package com.akso.spring.config;

import com.akso.spring.bean.Car;
import com.akso.spring.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * bean 的生命周期
 *  bean 的创建---初始化----销毁的过程
 *  容器管理bean 的生命周期
 *
 *  构造创建对象
 *      单实例： 在容器启动的时候创建对象
 *      多实例： 在每次获取的时候创建对象
 *
 *   初始化：
 *          对象创建完成， 并赋值好， 调用初始化方法
 *   销毁：
 *          单实例： 容器关闭的时候
 *          多实例： 容器不会管理这这个bean； 容器不会调用销毁方法
 *
 *   1. 指定初始化和销毁的方法
 *      通过@Bean指定initmethod和destroymethod
 *   2. 通过Bean 实现InitializingBean（定义初始化逻辑）DisposeableBean（定义销毁逻辑）
 *   3. 可以使用JSR250规范注解来进行初始化和销毁
 *      3.1 @PostConstruct： 在bean 创建完成并且属性赋值完成； 来是执行初始化
 *      3.2 @PreDestroy : 在容器销毁bean 之前通知我们进行清理工作
 *   4. BeanPostProcessor: bean 的后置处理器
 *      在bean 初始化的前后进行处理
 *      postProcessBeforeInitialization: 在初始化之前工作
 *      postProcessAfterInitialization: 在初始化之后工作
 */

@ComponentScan("com.akso.spring.bean")
@Configuration
@PropertySource(value={"classpath:person.properties"})
public class MainConfigOfProperty {

    @Bean
    public Person person() {
        return new Person();
    }
}
