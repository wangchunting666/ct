package com.ct.supervene.component;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2018/6/3.
 */
public class PrioritizedTask implements Runnable,Comparable<PrioritizedTask>{
    private Random random = new Random(47);
    private static int counter = 0;
    private final int id = counter++;
    private final int priority;
    private static List<PrioritizedTask> sequence = new ArrayList<>();
    public PrioritizedTask(int priority){
        this.priority = priority;
        sequence.add(this);
    }
    @Override
    public int compareTo(PrioritizedTask o) {
        return priority < o.priority ? 1:(priority > o.priority ? -1:0);
    }

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(random.nextInt(250));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return priority +" Task "+id;
    }

    public String summary(){
        return "("+id+":"+priority+")";
    }

    public static class EndSentinel extends PrioritizedTask{
        private ExecutorService exec;
        public EndSentinel(ExecutorService exec) {
            super(-1);
            this.exec = exec;
        }

        @Override
        public void run() {
            int count = 0;
            for (PrioritizedTask pt:sequence){
                System.out.println(pt.summary());
                if(++count % 5 == 0)
                    System.out.println();
            }
            System.out.println();
            System.out.println(this + " Calling shutdownNow()");
            exec.shutdownNow();
        }
    }
}

class PrioritizedTaskProducer implements Runnable{
    private Random random = new Random(47);
    private Queue<Runnable> queue;
    private ExecutorService exec;
    public PrioritizedTaskProducer(Queue<Runnable> queue,ExecutorService exec){
        this.queue = queue;
        this.exec = exec;
    }
    @Override
    public void run() {
        for (int i=0; i<20; i++){
            queue.add(new PrioritizedTask(random.nextInt(10)));
            Thread.yield();
        }
        try {
            for (int i=0;i<10;i++){
                TimeUnit.MILLISECONDS.sleep(250);
                queue.add(new PrioritizedTask(10));
            }
            for (int i=0; i<10;i++){
                queue.add(new PrioritizedTask(i));
            }
            queue.add(new PrioritizedTask.EndSentinel(exec));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Finished Prioritized");
    }
}

class PrioritizedTaskConsumer implements Runnable{
    private PriorityBlockingQueue<Runnable> priorityBlockingQueue;
    public PrioritizedTaskConsumer(PriorityBlockingQueue<Runnable> priorityBlockingQueue){
        this.priorityBlockingQueue = priorityBlockingQueue;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                priorityBlockingQueue.take().run();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Finished PrioritizedTaskConsumer");
    }

    public static void main(String[] args) {
        Random random = new Random(47);
        ExecutorService exec = Executors.newCachedThreadPool();
        PriorityBlockingQueue<Runnable> queue = new PriorityBlockingQueue<>();
        exec.execute(new PrioritizedTaskProducer(queue,exec));
        exec.execute(new PrioritizedTaskConsumer(queue));
    }
}
