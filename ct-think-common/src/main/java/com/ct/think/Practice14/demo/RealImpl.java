package com.ct.think.Practice14.demo;

/**
 * Created by Herdsric-M-003 on 2018/3/29.
 */
public class RealImpl implements SupperInterface{
    @Override
    public void doSomething() {
        System.out.println("RealImpl:doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("RealImpl:somethingElse-"+arg);
    }
}
