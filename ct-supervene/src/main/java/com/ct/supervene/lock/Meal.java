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
public class Meal {
    private final int orderNum;
    public Meal(int orderNum){
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Meal " + orderNum;
    }
}

class WaitPerson implements Runnable{
    private Restaurant restaurant;
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();
    public WaitPerson(Restaurant restaurant){
        this.restaurant = restaurant;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                lock.lock();
                try {
                    while (restaurant.meal == null) condition.await();
                }finally {
                    lock.unlock();
                }

                System.out.println("WaitPerson got meal " + restaurant.meal);

                Chef.lock.lock();
                try {
                    restaurant.meal = null;
                    Chef.condition.signalAll();
                }finally {
                    Chef.lock.unlock();
                }
            }
        }catch (InterruptedException e){
            System.out.println("WaitPerson InterruptedException exception");
        }
    }
}

class Chef implements Runnable{
    private Restaurant restaurant;
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();
    private int count = 0;
    public Chef(Restaurant restaurant){
        this.restaurant = restaurant;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                lock.lock();
                try {
                    while (restaurant.meal != null) condition.await();
                }finally {
                    lock.unlock();
                }

                System.out.println("Meal is null " + restaurant.meal);

                if(++count == 10){
                    System.out.println("Food out");
                    restaurant.exec.shutdownNow();
                    //return;
                }

                TimeUnit.MILLISECONDS.sleep(100);

                WaitPerson.lock.lock();
                try {
                    restaurant.meal = new Meal(count);
                    WaitPerson.condition.signalAll();
                }finally {
                    WaitPerson.lock.unlock();
                }
            }
        }catch (InterruptedException e){
            System.out.println("Chef InterruptedException exception");
        }
    }
}

class Restaurant{
    Meal meal;
    ExecutorService exec = Executors.newCachedThreadPool();
    WaitPerson waitPerson = new WaitPerson(this);
    Chef chef = new Chef(this);
    public Restaurant(){
        exec.execute(waitPerson);
        exec.execute(chef);
    }

    public static void main(String[] args) {
        new Restaurant();
    }
}