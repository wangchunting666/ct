package com.ct.think.Practice14.demo;

/**
 * Created by Herdsric-M-003 on 2018/3/29.
 */
public class SupperProxyImpl implements SupperInterface{
    private SupperInterface supper;

    public SupperProxyImpl(SupperInterface supper){
        this.supper = supper;
    }

    @Override
    public void doSomething() {
        System.out.println("使用代理类执行:doSomething");
        supper.doSomething();
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("使用代理类执行:somethingElse");
        supper.somethingElse(arg);
    }
}
