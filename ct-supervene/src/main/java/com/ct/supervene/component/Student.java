package com.ct.supervene.component;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2018/6/3.
 */
public class Student implements Runnable,Delayed{
    private String name;
    private long workTime;
    private long submitTime;
    private boolean isForce = false;
    private CountDownLatch countDownLatch;

    public Student(){}
    public Student(String name,long workTime,CountDownLatch countDownLatch){
        this.name = name;
        this.workTime = workTime;
        this.submitTime = TimeUnit.NANOSECONDS.convert(workTime, TimeUnit.NANOSECONDS)+System.nanoTime();
        this.countDownLatch = countDownLatch;
    }
    @Override
    public long getDelay(TimeUnit unit) {
        return 0;
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }

    @Override
    public void run() {

    }

}
