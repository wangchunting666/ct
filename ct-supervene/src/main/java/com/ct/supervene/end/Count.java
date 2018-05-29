package com.ct.supervene.end;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2018/5/29.
 */
class Count {
    private int count = 0;
    private Random random = new Random(47);
    public synchronized int increment(){
        int temp = count;
        //if(random.nextBoolean()) Thread.yield();
        return (count = ++temp);
    }
    public synchronized int value(){return count;}
}

class Entrance implements Runnable{
    public static Count count = new Count();
    public static List<Entrance> entrances = new ArrayList<>();
    private int number;
    private final int id;
    private static volatile boolean canceled = false;
    public static void cancel(){canceled = true;}
    public Entrance(int id){
        this.id = id;
        entrances.add(this);
    }
    @Override
    public void run() {
        while (!canceled){
            synchronized(this){
                ++number;
            }
            System.out.println(this + " Total " + count.increment());
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public synchronized int getValue(){return number;}

    @Override
    public String toString() {
        return "Entrance "+id+":"+getValue();
    }

    public static int getTotalCount(){
        return count.value();
    }
    public static int sumEntrances(){
        int sum = 0;
        for (Entrance entrance:entrances){
            sum += entrance.getValue();
        }
        return sum;
    }

    public static void main(String[] args) throws Exception{
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i=0;i<5;i++){
            exec.execute(new Entrance(i));
        }
        TimeUnit.SECONDS.sleep(3);
        Entrance.cancel();
        exec.shutdown();
    }
}
