package com.ct.designPattern.observer;

import java.util.Observable;

/**
 * Created by Herdsric-M-003 on 2018/5/1.
 */
public class SubjectJdk extends Observable{
    private String data;

    public void setData(String data) {
        this.data = data;
        setChanged();
        notifyObservers(null);
    }

    public String getData() {
        return data;
    }

}
