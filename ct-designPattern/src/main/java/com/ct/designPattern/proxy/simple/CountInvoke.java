package com.ct.designPattern.proxy.simple;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by dell on 2018/5/3.
 */
public class CountInvoke implements InvocationHandler{
    private int count = 0;
    private Object obj;
    public CountInvoke(Object obj){
        this.obj = obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        count++;
        method.invoke(obj,args);
        return null;
    }
    int getCount(){
        return count;
    }
}

class GenericProxy{
    public static Object createProxy(Object obj,InvocationHandler invokeObj){
        Object proxy = Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                invokeObj
        );
        return proxy;
    }
}
