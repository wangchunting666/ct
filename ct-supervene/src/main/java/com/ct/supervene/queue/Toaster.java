package com.ct.supervene.queue;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2018/6/2.
 */
class Toaster implements Runnable{
    private ToastQueue toastQueue;
    private int count = 0;
    private Random rand = new Random(47);
    public Toaster(ToastQueue tq){
        toastQueue = tq;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(100+rand.nextInt(500));
                Toast toast = new Toast(count++);
                System.out.println(toast);
                toastQueue.put(toast);
            }
        }catch (InterruptedException e){
            System.out.println("Toaster Interrupted");
        }
        System.out.println("Toaster Off");
    }
}

class Butterer implements Runnable{
    private ToastQueue dryQueue,butteredQueue;
    public Butterer(ToastQueue dryQueue,ToastQueue butteredQueue){
        this.dryQueue = dryQueue;
        this.butteredQueue = butteredQueue;
    }
    @Override
    public void run() {
        try{
            while (!Thread.interrupted()){
                Toast toast = dryQueue.take();
                toast.buffer();
                System.out.println(toast);
                butteredQueue.put(toast);
            }
        }catch (InterruptedException e){
            System.out.println("Butterer Interrupted");
        }
        System.out.println("Butterer Off");
    }
}

class Jammer implements Runnable{
    private ToastQueue bufferedQueue,jammedQueue;
    public Jammer(ToastQueue bufferedQueue,ToastQueue jammedQueue){
        this.bufferedQueue = bufferedQueue;
        this.jammedQueue = jammedQueue;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                Toast toast = bufferedQueue.take();
                toast.jam();
                System.out.println(toast);
                jammedQueue.put(toast);
            }
        }catch (InterruptedException e){
            System.out.println("Jammer interrupt");
        }
        System.out.println("Jammer Off");
    }
}

class Eater implements Runnable{
    private ToastQueue toastQueue;
    private int counter = 0;
    public Eater(ToastQueue toastQueue){
        this.toastQueue = toastQueue;
    }
    @Override
    public void run() {
        try {
            Toast toast = toastQueue.take();
            if(toast.getId() != counter++ || toast.getStatus() != Toast.Status.JAMMED){
                System.out.println(">>>>> Error:" + toast);
                System.exit(1);
            }else {
                System.out.println("Chomp! "+toast);
            }
        }catch (InterruptedException e){
            System.out.println("Eater Interrupt");
        }
        System.out.println();
    }
}