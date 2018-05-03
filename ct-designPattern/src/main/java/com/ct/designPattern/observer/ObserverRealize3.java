package com.ct.designPattern.observer;

/**
 * Created by Herdsric-M-003 on 2018/5/1.
 */
public class ObserverRealize3 implements IObserver<String> {
    @Override
    public void refresh(String data) {
        System.out.println("ObserverRealize3:This is a data :"+data);
    }
}
