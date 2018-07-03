package com.source.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by Herdsric-M-003 on 2018/7/3.
 */
@Aspect
public class AspectJTest {
    @Pointcut("execution(* *.test(..))")
    public void test(){

    }
    @Before("test()")
    public void beforeTest(){
        System.out.println("beforeTest");
    }
    @After("test()")
    public void afterTest(){
        System.out.println("afterTest");
    }
    @Around("test()")
    public Object aroundTest(ProceedingJoinPoint p){
        System.out.println("before1");
        Object o = null;
        try {
            o = p.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("after1");
        return o;
    }
}
