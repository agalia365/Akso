package com.akso.spring.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect
public class LogAspect {

    //抽取公共的切入点
    // 1. 本类应用
    // 2. 其他类应用
    @Pointcut("execution(public int com.akso.spring.aop.MathCalculator.*(int, int))")
    public void pointCut() {
    }

    // @Before 在目标方法之前切入, 切入点表达式（指定在哪个方法切入）
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "除法运行。。。参数列表是: {" + Arrays.asList(joinPoint.getArgs()) + " }");
    }

    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + "除法结束........");
    }

    // JoinPoint joinPoint 参数一定要出现在参数表的第一位
    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        System.out.println(joinPoint.getSignature().getName() + "除法正常返回。。。。 运算结果： {" + result + "}");
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logException(JoinPoint joinPoint, Exception exception) {
        System.out.println(joinPoint.getSignature().getName() + "除法异常， 异常信息: {" + exception + "}");
    }
}
