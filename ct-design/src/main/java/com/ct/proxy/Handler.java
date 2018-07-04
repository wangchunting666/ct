package com.ct.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Herdsric-M-003 on 2018/7/4.
 */
class Handler implements InvocationHandler{
    private Object target;//代理对象
    public Handler(Object target){this.target = target;}
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理方法执行前");
        method.invoke(target,args);
        System.out.println("代理方法执行后");
        return proxy;
    }

}
