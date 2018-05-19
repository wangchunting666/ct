package com.ct.observer.application;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by dell on 2018/5/19.
 */
class Subject extends Observable{
    private String data;
    public void setData(String data) {
        this.data = data;
    }
    public String getData() {
        return data;
    }
}

class Observe implements Observer{

    @Override
    public void update(Observable o, Object arg) {
        
    }
}


