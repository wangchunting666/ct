package com.ct.designPattern.observer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Herdsric-M-003 on 2018/5/1.
 */
public class SubjectPull implements ISubject{
    private List<IObserver> observerList = new LinkedList<>();
    private String data;

    public void setData(String data) {this.data = data;}

    public String getData() {return data;}

    @Override
    public void register(IObserver observer) {
        if(!observerList.contains(observer)) observerList.add(observer);
    }

    @Override
    public void unregister(IObserver observer) {
        if(observerList.contains(observer)) observerList.remove(observer);
    }
    @Override
    public void notifyAllObserver() {
        for (IObserver ob:observerList) ob.refresh(this);
    }
}
