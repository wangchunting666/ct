package com.ct.designPattern.observer;

/**
 * Created by Herdsric-M-003 on 2018/5/1.
 */
public interface IObserver<T> {
    void refresh(T data);
}
