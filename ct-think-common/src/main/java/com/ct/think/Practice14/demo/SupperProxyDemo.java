package com.ct.think.Practice14.demo;

/**
 * Created by Herdsric-M-003 on 2018/3/29.
 */
public class SupperProxyDemo {

    public void consume(SupperInterface supper){
        supper.doSomething();
        supper.somethingElse("consume");
    }

    public static void main(String[] args){
        SupperProxyDemo demo = new SupperProxyDemo();
        demo.consume(new RealImpl());
        demo.consume(new SupperProxyImpl(new RealImpl()));
    }
}
