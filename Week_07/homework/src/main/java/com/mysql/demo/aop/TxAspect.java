package com.mysql.demo.aop;

import com.mysql.demo.annotation.Action;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * aop 面向编程
 *
 * 怎么实现切点？
 * 1.通过包扫描，特定的包下的什么方法，作为切点
 * 2.通过注解方式
 *
 *
 * 怎么试下织入？
 * 使用jdk动态代理，对切点进行织入
 */

@Aspect
public class TxAspect {

//    @Pointcut("execution(* com.mysql.demo.aop.Customer.*(..))")
//    public void pointcut(){}

    @Pointcut(" @annotation(com.mysql.demo.annotation.Action)")
    public void annotationPoinCut(){}

    @Before("annotationPoinCut()")
    public void startTx(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("注解式拦截" + action.name());
        System.out.println("开启事务");
    }

    @After("annotationPoinCut()")
    public void commitTx(JoinPoint joinPoint){
        System.out.println("提交事务");
    }
}


