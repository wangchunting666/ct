package com.ct.designPattern.observer;

/**
 * Created by Herdsric-M-003 on 2018/5/1.
 */
public class ObserverRealize2 implements IObserver<SubjectPull> {
    @Override
    public void refresh(SubjectPull data) {
        System.out.println("This is a ObserverRealize2"+data.getData());
    }
}
