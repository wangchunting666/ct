package com.ct.supervene.component;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2018/6/3.
 */
class TaskPortion implements Runnable{
    private static int counter = 0;
    private final int id = counter++;
    private static Random random = new Random();
    private final CountDownLatch latch;
    public TaskPortion(CountDownLatch latch){
        this.latch = latch;
    }
    @Override
    public String toString() {
        return "TaskPortion "+id;
    }
    public void doWork() throws InterruptedException{
        TimeUnit.MILLISECONDS.sleep(random.nextInt(2000));
        System.out.println(this+" work complete");
    }
    @Override
    public void run() {
        try {
            doWork();
            latch.countDown();
        }catch (InterruptedException e){
            System.out.println(this+" Interrupted");
        }
    }
}

class WaitingTask implements Runnable{
    private static int counter = 0;
    private final int id = counter++;
    private CountDownLatch latch;
    public WaitingTask(CountDownLatch latch){
        this.latch = latch;
    }

    @Override
    public String toString() {
        return "WaitingTask "+id;
    }

    @Override
    public void run() {
        try {
            latch.await();
            System.out.println("Latch barrier passed for "+this);
        }catch (InterruptedException e){
            System.out.println(this + " InterruptedException");
        }
    }
}
