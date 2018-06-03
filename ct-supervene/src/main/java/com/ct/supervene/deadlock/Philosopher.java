package com.ct.supervene.deadlock;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2018/6/2.
 */
public class Philosopher implements Runnable{
    private Chopstick left;
    private Chopstick right;
    private final int id;
    private final int ponderFactor;
    private Random random = new Random(47);
    public Philosopher(Chopstick left,Chopstick right,int id,int ponderFactor){
        this.left = left;
        this.right = right;
        this.id = id;
        this.ponderFactor = ponderFactor;
    }
    public void pause() throws InterruptedException{
        if(ponderFactor == 0) return;
        TimeUnit.MILLISECONDS.sleep(random.nextInt(ponderFactor*250));
    }

    @Override
    public String toString() {
        return "Philosopher " + id;
    }

    @Override
    public void run() {
        try {
            while (Thread.interrupted()){
                System.out.println(this+" "+"thinking");
                pause();
                System.out.println(this + " " + "grabbing right");
                right.take();
                left.take();
                System.out.println(this +" "+ "eating");
                right.drop();
                left.drop();
            }
        }catch (InterruptedException e){
            System.out.println(this + " " + "exiting via interrupt");
        }
    }

    public static void main(String[] args) throws Exception{
        int ponder = 5;
        int size = 5;
        ExecutorService exec = Executors.newCachedThreadPool();
        Chopstick[] sticks = new Chopstick[size];
        for (int i=0; i<size; i++){
            sticks[i] = new Chopstick();
        }
        for (int i=0; i<size; i++){
            exec.execute(new Philosopher(sticks[i],sticks[(i+1) % size],i,ponder));
        }
        TimeUnit.SECONDS.sleep(5);
    }
}
