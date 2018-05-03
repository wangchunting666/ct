package com.ct.designPattern.proxy.simple;

/**
 * Created by dell on 2018/5/3.
 */
public interface IPerson {
    void searchHouse();
}

class Person implements IPerson{
    @Override
    public void searchHouse() {
        System.out.println("Real Person");
    }
}
