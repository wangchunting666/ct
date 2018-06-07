package com.ct.supervene.resource;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2018/5/29.
 */
class ThreadLocalVariableHolder {
    private static ThreadLocal<Integer> value = new ThreadLocal<Integer>(){
        private Random random = new Random(47);
        protected synchronized Integer initialValue(){
            return random.nextInt(10000);
        }
    };
    public static void increment(){
        value.set(value.get() + 1);
    }
    public static int get(){
        return value.get();
    }

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0;i<5;i++){
            executorService.execute(new Accessor(i));
        }
        TimeUnit.SECONDS.sleep(3L);
        executorService.shutdownNow();
    }
}
class Accessor implements Runnable{
    private final int id;
    public Accessor(int idn){
        this.id = idn;
    }
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            ThreadLocalVariableHolder.increment();
            System.out.println(this);
            Thread.yield();
        }
    }

    @Override
    public String toString() {
        return "#"+id+":"+ThreadLocalVariableHolder.get();
    }
}