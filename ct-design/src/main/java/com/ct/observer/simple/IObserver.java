package com.ct.observer.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2018/5/19.
 */
interface IObserver {
    void refresh(String name);
}
class Observer implements IObserver{
    @Override
    public void refresh(String name) {
        System.out.println("刷新:"+name);
    }
}
interface ISubject{
    void regist(IObserver os);
    void unregist(IObserver os);
    void notifyObservers();
}
class Subject implements ISubject{

    public Subject(String name){
        this.name = name;
    }

    List<IObserver> list = new ArrayList<>();

    private String name;

    @Override
    public void regist(IObserver os) {
        list.add(os);
    }

    @Override
    public void unregist(IObserver os) {
        if(list.contains(os)) list.remove(os);
    }

    @Override
    public void notifyObservers() {
        for(IObserver observer:list){
            observer.refresh("");
        }
    }
}