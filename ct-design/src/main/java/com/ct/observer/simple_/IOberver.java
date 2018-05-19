package com.ct.observer.simple_;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2018/5/19.
 */
interface IObserver<T> {
    void refresh(T name);
}
interface ISubject{
    void regist(IObserver os);
    void unregist(IObserver os);
    void notifyObservers();
}

class Observer implements IObserver<String>{
    @Override
    public void refresh(String name) {
        System.out.println("刷新:"+name);
    }
}

class Subject implements ISubject {

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
            observer.refresh(name);
        }
    }

    public static void main(String[] args) {

    }
}
