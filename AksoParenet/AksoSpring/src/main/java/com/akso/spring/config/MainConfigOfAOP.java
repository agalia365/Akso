package com.akso.spring.config;

import com.akso.spring.aop.LogAspect;
import com.akso.spring.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * AOP[动态代理]
 * ： 指在程序运行期间动态的将某段代码切入到指定方法指定位置进行的编程方式
 * 1. 导入AOP模块， Spring AOP（spring-aspects）
 * 2. 定义一个业务逻辑类, 在业务逻辑运行的时候， 将日志打印（方法之前，方法结束， 方法异常）
 * 3. 定义一个日志切面类（LogAspect），切面类里面的方法需要动态感知MathCalculator.div运行到哪里， 然后执行
 * 通知方法：
 * 前置通知(@Before)：logStart, 在目标方法运行之前通知
 * 后置通知(@After): logEnd， 在目标方法运行后通知(无论方法正常还是异常，方法都会调用）
 * 返回通知(@AfterReturning)：logRetrun 在目标方法运行返回后通知
 * 异常通知(@AfterThrowing)： logException 在目标方法运行出现异常的时候通知
 * 环绕通知(@Around)： 动态代理， 手动推进目标方法进行(joinPoint.proceed())
 * 4. 给切面类的目标方法标注何时何地运行()
 * 5. 将切面类和目标（业务逻辑类）目标方法都加入到容器中
 * 6. 告诉容器哪个是切面类, 给切面类加一个注解
 * 7. 给配置类加@EnableAspectJAutoProxy开启基于注解的aop模式
 * spring 中有很多@EnableXXXX
 * <p>
 * 三步：
 * 1） 。 将业务逻辑类和切面类都加入到容器中； 告诉spring 哪个是切面类（@Aspect）
 * 2）。 在切面类的每一个方法上标注通知注解， 告诉spring何时何地运行（切入点表达式）
 * 3）。 开启基于注解的aop 模式（@EnableAspectJAutoProxy）
 * <p>
 * <p>
 * AOP原理：
 *
 * @EnableAspectJAutoProxy
 */
@Configuration
@EnableAspectJAutoProxy
public class MainConfigOfAOP {

    // 将业务容器类加入到容器中
    @Bean
    public MathCalculator mathCalculator() {
        return new MathCalculator();
    }

    // 将切面类加入到容器中
    @Bean
    public LogAspect logAspect() {
        return new LogAspect();
    }
}
