package com.ct.designPattern.observer;

/**
 * Created by Herdsric-M-003 on 2018/5/1.
 */
public interface ISubjectXml {
    void register(String xml);
    void unregister(IObserver observer);
    void notifyAllObserver();
}
