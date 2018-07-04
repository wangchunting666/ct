package com.ct.supervene.semaphore;

import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2018/6/3.
 */
public class CheckoutTask<T> implements Runnable{
    private static int counter  = 0;
    private final int id = counter++;
    private Pool<T> pool;
    public CheckoutTask(Pool<T> pool){
        this.pool = pool;
    }
    @Override
    public void run() {
        try {
            T item = pool.checkOut();
            System.out.println(this + " checked Out "+item);
            TimeUnit.SECONDS.sleep(1);
            System.out.println(this + " checked In "+item);
            pool.checkIn(item);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "CheckoutTask "+id+" ";
    }
}
