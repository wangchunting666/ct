package com.ct.supervene.component;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2018/6/3.
 */
public class Human implements Runnable,Comparable<Human>{
    private String name;
    private int money;
    public Human(String name,int money){
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    @Override
    public int compareTo(Human o) {
        return o.getMoney() - this.getMoney();
    }

    @Override
    public void run() {
        try {
            System.out.println(this + ":开始存钱");
            TimeUnit.MILLISECONDS.sleep(1000);
        }catch (InterruptedException e){
            System.out.println("Huamn InterruptedException");
        }
    }

    @Override
    public String toString() {
        return getName()+":"+getMoney();
    }
}

class ProducerRunnable implements Runnable{
    private static final String name = "明刚红李刘吕赵黄王孙朱曾游丽吴昊周郑秦丘";
    private Random random = new Random(47);
    private PriorityBlockingQueue<Human> priorityBlockingQueue;
    public ProducerRunnable(PriorityBlockingQueue<Human> priorityBlockingQueue){
        this.priorityBlockingQueue = priorityBlockingQueue;
    }
    @Override
    public void run() {
        for (int i=0; i<20; i++){
            Human human = new Human("小"+name.charAt(i),random.nextInt(10000));
            priorityBlockingQueue.put(human);
            System.out.println(human + "开始排队....");
        }
    }
}

class ConsumerRunnable implements Runnable{
    private PriorityBlockingQueue<Human> priorityBlockingQueue;
    public ConsumerRunnable(PriorityBlockingQueue priorityBlockingQueue){
        this.priorityBlockingQueue = priorityBlockingQueue;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                Human human = priorityBlockingQueue.take();
                human.run();
            }
        }catch (InterruptedException e){
            System.out.println("ConsumerRunnable InterruptedException");
        }
    }

    public static void main(String[] args) throws Exception{
        PriorityBlockingQueue<Human> priorityBlockingQueue = new PriorityBlockingQueue<>();
        ProducerRunnable producerRunnable = new ProducerRunnable(priorityBlockingQueue);
        ConsumerRunnable consumerRunnable = new ConsumerRunnable(priorityBlockingQueue);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(consumerRunnable);
        exec.execute(producerRunnable);
        TimeUnit.SECONDS.sleep(20);
        exec.shutdownNow();
    }
}
