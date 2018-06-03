package com.ct.supervene.component;

import javax.sound.midi.Sequence;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by dell on 2018/6/3.
 */
public class DelayedTask implements Runnable,Delayed{
    private static int counter = 0;
    private final int id = counter++;
    private final int delta;
    private final long trigger;
    protected static List<DelayedTask> sequence = new ArrayList<>();
    public DelayedTask(int delayInMilliseconds){
        delta = delayInMilliseconds;
        trigger = TimeUnit.NANOSECONDS.convert(delta, TimeUnit.MILLISECONDS)+System.nanoTime();
        sequence.add(this);
    }
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(
                trigger - System.nanoTime(),TimeUnit.NANOSECONDS
        );
    }

    @Override
    public int compareTo(Delayed o) {
        DelayedTask that = (DelayedTask) o;
        if(trigger < that.trigger) return -1;
        if(trigger > that.trigger) return 1;
        return 0;
    }

    @Override
    public void run() {
        System.out.println(this+" ");
    }

    @Override
    public String toString() {
        return delta+" Task "+id;
    }

    public String summary(){
        return "("+id+":"+delta+")";
    }

    public static class EndSentinel extends DelayedTask{
        private ExecutorService exec;
        public EndSentinel(int delayInMilliseconds,ExecutorService exec) {
            super(delayInMilliseconds);
            this.exec = exec;
        }

        @Override
        public void run() {
            for(DelayedTask pt: sequence){
                System.out.println(pt.summary()+" ");
            }
            System.out.println(this + " Calling shutdownNow()");
            exec.shutdownNow();
        }
    }
}

class DelayedTaskConsumer implements Runnable{
    private DelayQueue<DelayedTask> delayedTasks;
    public DelayedTaskConsumer(DelayQueue<DelayedTask> delayedTasks){
        this.delayedTasks = delayedTasks;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted())
                delayedTasks.take().run();
        }catch (InterruptedException e){
            System.out.println("DelayedTaskConsumer InterruptedException");
        }
        System.out.println("Finished DelayedTaskConsumer");
    }

    public static void main(String[] args) {
        Random random = new Random(47);
        ExecutorService exec = Executors.newCachedThreadPool();
        DelayQueue<DelayedTask> queue = new DelayQueue<>();
        for(int i=0; i<20; i++){
            queue.put(new DelayedTask(random.nextInt(5000)));
        }
        queue.add(new DelayedTask.EndSentinel(5000,exec));
        exec.execute(new DelayedTaskConsumer(queue));
    }
}
