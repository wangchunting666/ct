package com.ct.supervene.queue;

import com.ct.supervene.simple.LiftOff;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2018/6/2.
 */
public class LiftOffRuner implements Runnable{
    private BlockingQueue<LiftOff> rokets;
    public LiftOffRuner(BlockingQueue rokets){
        this.rokets = rokets;
    }
    public void add(LiftOff liftOff){
        rokets.add(liftOff);
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                LiftOff liftOff = rokets.take();//队列堵塞
                liftOff.run();
                TimeUnit.SECONDS.sleep(5);
            }
        }catch (InterruptedException e){
            System.out.println("Exit via InterruptedException");
        }
    }
}
