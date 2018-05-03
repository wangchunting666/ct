package com.ct.designPattern.observer;

import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/**
 * Created by Herdsric-M-003 on 2018/5/1.
 */
public class SubjectXml implements ISubjectXml{
    private List<IObserver> observerList = new LinkedList<>();
    private String data;

    public void setData(String data) {this.data = data;}

    public String getData() {return data;}
    @Override
    public void register(String xml) {
        Properties p = new Properties();
        try {
            p.loadFromXML(this.getClass().getResourceAsStream(xml));
            for(String key:p.stringPropertyNames()){
                if(key.contains("observer")){
                    IObserver ob = (IObserver)Class.forName(p.getProperty(key)).newInstance();
                    observerList.add(ob);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void unregister(IObserver observer) {if(observerList.contains(observer)) observerList.remove(observer);}

    @Override
    public void notifyAllObserver() {
        for (IObserver ob:observerList) ob.refresh(data);
    }
}
