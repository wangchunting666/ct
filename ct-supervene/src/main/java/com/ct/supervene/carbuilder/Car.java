package com.ct.supervene.carbuilder;

import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by Herdsric-M-003 on 2018/6/5.
 */
public class Car {
    private final int id;
    private boolean engine = false,driveTrain=false,wheels=false;
    public Car(int id){this.id = id;}
    public Car(){this.id = -1;}
    public synchronized int getId() {
        return id;
    }
    public synchronized void addEngine(){engine = true;}
    public synchronized void addDriveTrain(){driveTrain = true;}
    public synchronized void addWheels(){wheels = true;}
    @Override
    public synchronized String toString() {
        return "Car "+id+"["+" engine:"+engine+" driveTrain:"+driveTrain+" wheels:"+wheels+"]";
    }

    public static void main(String[] args) {
        System.out.println(false && null == null || "".equals(null));
    }
}
