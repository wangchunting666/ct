package com.ct.designPattern.proxy.simple;

/**
 * Created by Herdsric-M-003 on 2018/5/3.
 */
public interface IRegist {
    void regist(String msg);
}

class FromEmail implements IRegist{

    @Override
    public void regist(String msg) {
        System.out.println("from Email");
    }
}

class FromPost implements IRegist{

    @Override
    public void regist(String msg) {
        System.out.println("from post");
    }
}