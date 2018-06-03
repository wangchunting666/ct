package com.ct.supervene.end;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2018/5/31.
 */
public class BusyRun {
    private boolean flag = false;
    public synchronized void setFlag(boolean b){
        this.flag = b;
    }
    public synchronized boolean getFlag(){
        return flag;
    }

    public static void main(String[] args) throws Exception{
        ExecutorService exec = Executors.newCachedThreadPool();
        BusyRun busyRun = new BusyRun();
        exec.execute(new BusyRunTest1(busyRun));
        exec.execute(new BusyRunTest2(busyRun));
        TimeUnit.SECONDS.sleep(10);
        exec.shutdownNow();
    }
}

class BusyRunTest1 implements Runnable{
    private BusyRun busyRun;
    public BusyRunTest1(BusyRun busyRun){
        this.busyRun = busyRun;
    }
    public synchronized void waitonly() throws InterruptedException{
        wait(4000);
    }
    @Override
    public void run() {
        try {
            waitonly();
            System.out.println("Waiing exddd");
            busyRun.setFlag(true);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class BusyRunTest2 implements Runnable{
    private BusyRun busyRun;
    public BusyRunTest2(BusyRun busyRun){
        this.busyRun = busyRun;
    }
    @Override
    public void run() {
        try {
            while (true){
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Observing");
                if(busyRun.getFlag()) {
                    busyRun.setFlag(false);
                    System.out.println("BusyRun: true to false");
                    break;
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}