package com.ct.supervene.exchange;

import com.ct.supervene.semaphore.Fat;

import java.util.List;
import java.util.concurrent.*;

/**
 * Created by dell on 2018/6/3.
 */
public class ExchangerProducer<T> implements Runnable {
    private Generator<T> generator;
    private Exchanger<List<T>> exchanger;
    private List<T> holder;
    ExchangerProducer(Generator<T> generator,Exchanger<List<T>> exchanger,List<T> holder){
        this.generator =generator;
        this.exchanger = exchanger;
        this.holder = holder;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                for (int i = 0; i < ExchangerDemo.size; i++) {
                    holder.add(generator.next());
                }
                holder = exchanger.exchange(holder);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class ExchangerConsumer<T> implements Runnable{
    private List<T> holder;
    private Exchanger<List<T>> exchanger;
    private volatile T value;
    public ExchangerConsumer(List<T> holder,Exchanger<List<T>> exchanger){
        this.holder = holder;
        this.exchanger = exchanger;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                holder = exchanger.exchange(holder);
                for (T x : holder) {
                    System.out.println(x);
                    value = x;
                    holder.remove(x);
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Final value "+value);
    }
}
class ExchangerDemo{
    static int size = 10;
    static int delay = 5;
    public static void main(String[] args) throws Exception{
        ExecutorService exec = Executors.newCachedThreadPool();
        Exchanger<List<Fat>> xc= new Exchanger<>();
        List<Fat>
                producerList = new CopyOnWriteArrayList<>(),
                consumerList = new CopyOnWriteArrayList<>();
        exec.execute(new ExchangerProducer<Fat>(BasicGenerator.create(Fat.class),xc,producerList));
        exec.execute(new ExchangerConsumer<Fat>(consumerList,xc));
        TimeUnit.SECONDS.sleep(delay);
        exec.shutdownNow();
    }
}
