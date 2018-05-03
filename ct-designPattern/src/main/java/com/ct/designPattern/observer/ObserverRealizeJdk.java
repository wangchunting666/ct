package com.ct.designPattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Herdsric-M-003 on 2018/5/1.
 */
public class ObserverRealizeJdk implements Observer{
    @Override
    public void update(Observable o, Object arg) {
        SubjectJdk subjectJdk = (SubjectJdk)o;
        System.out.println("This is JDK subject "+subjectJdk.getData()+":"+arg);
    }
}
