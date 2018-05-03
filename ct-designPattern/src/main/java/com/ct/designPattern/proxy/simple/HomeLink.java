package com.ct.designPattern.proxy.simple;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by dell on 2018/5/3.
 */
public class HomeLink implements InvocationHandler{

    private Object target;

    public Object getInstance(Object target){
        this.target = target;
        Class clzz = target.getClass();
        return Proxy.newProxyInstance(clzz.getClassLoader(),clzz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
