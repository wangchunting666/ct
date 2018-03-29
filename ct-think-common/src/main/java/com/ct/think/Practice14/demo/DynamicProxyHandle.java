package com.ct.think.Practice14.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Herdsric-M-003 on 2018/3/29.
 */
public class DynamicProxyHandle implements InvocationHandler{
    private Object supper;
    public DynamicProxyHandle(Object supper){
        this.supper = supper;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy:"+proxy.getClass()+",method:"+method+",args:"+args);
        return method.invoke(supper,args);
    }
}
