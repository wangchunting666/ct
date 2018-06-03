package com.ct.supervene.semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2018/6/3.
 */
public class SemaphoreDemo {
    private static final int SIZE = 25;
    public static void main(String[] args) throws Exception{
        final Pool<Fat> pool = new Pool<>(Fat.class,SIZE);
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i=0; i<SIZE; i++){
            exec.execute(new CheckoutTask<Fat>(pool));
        }
        TimeUnit.SECONDS.sleep(4);
        List<Fat> list = new ArrayList<>();
        for (int i=0; i<SIZE; i++){
            Fat f = pool.checkOut();
            System.out.println(i + ": main thread checked out ");
            f.operation();
            list.add(f);
        }
        TimeUnit.SECONDS.sleep(4);
        Future<?> blocked = exec.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    pool.checkOut();
                }catch (InterruptedException e){
                    System.out.println("checkOut() Interrupted");
                }
            }
        });
        TimeUnit.SECONDS.sleep(4);
        blocked.cancel(true);
        System.out.println("Checked in objects in "+list);
        for (Fat f:list){
            pool.checkIn(f);
        }
        for (Fat f:list){
            pool.checkIn(f);
        }
        exec.shutdown();
    }
}
