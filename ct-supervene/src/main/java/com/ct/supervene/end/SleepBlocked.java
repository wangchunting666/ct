package com.ct.supervene.end;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2018/5/30.
 */
class SleepBlocked implements Runnable{
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(100);
        }catch (InterruptedException e){
            System.out.println("InterruptedException");
        }
        System.out.println("Exiting SleepBlocked.run");
    }
}

class IOBlocked implements Runnable{
    private InputStream in;
    public IOBlocked(InputStream is){in=is;}
    @Override
    public void run() {
        try {
            System.out.println("Waitting for read():");
            in.read();
        }catch (IOException e){
            if(Thread.currentThread().isInterrupted()){
                System.out.println("Interrupted from blocked I/O");
            }else {
                throw new RuntimeException(e);
            }
            System.out.println("Exiting IOBlocked.run");
        }
    }
}

class SynchronizedBlocked implements Runnable{
    public synchronized void f(){
        while (true) {
            Thread.yield();
        }
    }
    public SynchronizedBlocked(){
        new Thread(){
            @Override
            public void run() {
                f();
            }
        }.start();
    }
    @Override
    public void run() {
        System.out.println("Try to call f()");
        f();
        System.out.println("Exiting SynchronizedBlocked.run()");
    }
}

