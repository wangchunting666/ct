package com.ct.supervene.end;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by dell on 2018/5/30.
 */
public class BlockedMutex {
    private Lock lock = new ReentrantLock();
    public BlockedMutex(){
        lock.lock();
    }
    public void f(){
        try {
            lock.lockInterruptibly();
            System.out.println("lock acquired in f()");
        } catch (InterruptedException e) {
            System.out.println("InterruptedException from lock ");
        }
    }
}
class Blocked2 implements Runnable{
    BlockedMutex blocked = new BlockedMutex();
    @Override
    public void run() {
        System.out.println("Waitting for BlockedMutex f()");
        blocked.f();
        System.out.println("Broken out of blocked call");
    }

    public static void main(String[] args) throws Exception{
        Thread thread = new Thread(new Blocked2());
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
    }
}
