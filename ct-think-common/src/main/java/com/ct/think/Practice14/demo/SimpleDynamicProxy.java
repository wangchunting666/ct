package com.ct.think.Practice14.demo;

import java.lang.reflect.Proxy;

/**
 * Created by Herdsric-M-003 on 2018/3/29.
 */
public class SimpleDynamicProxy {
    public static void consumer(SupperInterface supper){
        supper.doSomething();
        supper.somethingElse("执行");
    }
    public static void main(String[] args){
        SupperInterface supper = (SupperInterface)Proxy.newProxyInstance(
                SupperInterface.class.getClassLoader(),
                new Class[]{SupperInterface.class},
                new DynamicProxyHandle(new RealImpl()));
        consumer(supper);
    }
}
