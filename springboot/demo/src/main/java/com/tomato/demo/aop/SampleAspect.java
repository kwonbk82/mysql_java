package com.tomato.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Aspect
@Component
public class SampleAspect {
    @Before("execution(* com.tomato.demo.used.*Greet.*(..))")
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("______________");
        System.out.println(new SimpleDateFormat("yyyy/MM/dd")
        .format(new java.util.Date()));
        System.out.println(String.format("메서드: %s",joinPoint.getSignature().getName()));
    }
    @Around("execution(* com.tomato.demo.used.*Greet.*(..))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("______________");
        Object result = joinPoint.proceed();
        System.out.println("______________");
        return result;
    }
}
