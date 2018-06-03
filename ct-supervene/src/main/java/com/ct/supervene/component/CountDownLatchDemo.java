package com.ct.supervene.component;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by dell on 2018/6/3.
 */
public class CountDownLatchDemo {
    static final int SIZE = 100;

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(SIZE);
        for(int i=0; i<10; i++){
            exec.execute(new WaitingTask(latch));
        }
        for (int i=0; i<SIZE; i++){
            exec.execute(new TaskPortion(latch));
        }
        exec.shutdown();
    }
}
