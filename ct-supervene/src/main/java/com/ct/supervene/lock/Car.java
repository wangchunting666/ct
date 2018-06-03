package com.ct.supervene.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by dell on 2018/6/2.
 */
class Car {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean waxOn = false;
    public void waxed(){
        lock.lock();
        try {
            waxOn = true;
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }
    public void buffed(){
        lock.lock();
        try {
            waxOn = false;
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }
    public void waitForWaxing() throws InterruptedException{
        lock.lock();
        try {
            while (!waxOn) condition.await();
        }finally {
            lock.unlock();
        }
    }
    public void waitForBuffing() throws InterruptedException{
        lock.lock();
        try {
            while (waxOn) condition.await();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws Exception{
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(2);
        exec.shutdownNow();
    }
}

class WaxOn implements Runnable{
    private Car car;
    public WaxOn(Car car){
        this.car = car;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                System.out.println("WaxOn");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffing();
            }
        }catch (InterruptedException e){
            System.out.println("WaxOn Exit via InterruptedException");
        }
    }
}

class WaxOff implements Runnable{
    private Car car;
    public WaxOff(Car car){
        this.car = car;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                System.out.println("WaxOff");
                TimeUnit.MILLISECONDS.sleep(500);
                car.buffed();
                //car.waitForWaxing();
            }
        }catch (InterruptedException e){
            System.out.println("WaxOff Exit via InterruptedException");
        }
    }
}