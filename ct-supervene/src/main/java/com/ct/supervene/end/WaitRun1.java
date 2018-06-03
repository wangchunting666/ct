package com.ct.supervene.end;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2018/5/31.
 */
class WaitRun1 implements Runnable{
    private final int tid;
    public WaitRun1(int tid){
        this.tid = tid;
    }

    public synchronized void waitonly() throws InterruptedException{
        wait();
    }

    public synchronized void notifyonly(){
        notify();
    }

    @Override
    public String toString() {
        return "Thread"+tid;
    }

    @Override
    public void run() {
        try {
            System.out.println(this+" is running next wait");
            waitonly();
        }catch (InterruptedException e){
            System.out.println(this+" is InterruptedException over");
        }
        System.out.println(this+" is exit");
    }
}

class WaitRun2 implements Runnable{
    private WaitRun1 waitRun1;
    public WaitRun2(WaitRun1 waitRun1){
        this.waitRun1 = waitRun1;
    }
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(2);
            waitRun1.notifyonly();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(this+" is exit");
    }
}

class WaitRunTest{
    public static void main(String[] args) throws Exception{
        WaitRun1 run1 = new WaitRun1(1);
        WaitRun2 run2 = new WaitRun2(run1);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(run1);
        exec.execute(run2);
        TimeUnit.SECONDS.sleep(2);
        exec.shutdownNow();
    }
}
