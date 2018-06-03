package com.ct.supervene.customs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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
    public WaitPerson(Restaurant restaurant){
        this.restaurant = restaurant;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                synchronized (this){
                    while (restaurant.meal == null) wait();
                }

                System.out.println("WaitPerson got meal " + restaurant.meal);

                synchronized (restaurant.chef){
                    restaurant.meal = null;
                    restaurant.chef.notifyAll();
                }
            }
        }catch (InterruptedException e){
            System.out.println("WaitPerson InterruptedException exception");
        }
    }
}

class Chef implements Runnable{
    private Restaurant restaurant;
    private int count = 0;
    public Chef(Restaurant restaurant){
        this.restaurant = restaurant;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                synchronized (this){
                    while (restaurant.meal != null) wait();
                }

                System.out.println("Meal is null " + restaurant.meal);

                if(++count == 10){
                    System.out.println("Food out");
                    restaurant.exec.shutdownNow();
                    //return;
                }

                TimeUnit.MILLISECONDS.sleep(100);

                synchronized (restaurant.waitPerson){
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.notifyAll();
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