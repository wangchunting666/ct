package com.ct.proxy.simple;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by dell on 2018/5/19.
 */
interface Person {
    void name();
    void searchHouse();
}
class Master implements Person{

    @Override
    public void name() {
        System.out.println("master");
    }

    @Override
    public void searchHouse() {
        System.out.println("search...");
    }
}

class HomeLink implements InvocationHandler{

    private Person target;

    public Object getInstance(Person target){
        this.target = target;
        Class clazz = target.getClass();
        Object obj = Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
        return obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是链家，我帮别人找房子..");
        method.invoke(target, args);
        System.out.println("我是链家，已经找完了..");
        return null;
    }
}
