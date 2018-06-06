package com.ct.supervene.simulation;

/**
 * Created by Herdsric-M-003 on 2018/6/4.
 */
public class Customer {
    private final int serviceTime;
    public Customer(int serviceTime){
        this.serviceTime = serviceTime;
    }
    public int getServiceTime() {
        return serviceTime;
    }
    @Override
    public String toString() {
        return "["+serviceTime+"]";
    }
}
