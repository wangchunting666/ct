package com.ct.supervene.exchange;

import com.ct.supervene.semaphore.Fat;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
            while (!Thread.interrupted())
                for (int i=0; i<ExchangerDemo.size; i++){
                    holder.add(generator.next());
                };
            holder = exchanger.exchange(holder);
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
            while (!Thread.interrupted())
                holder = exchanger.exchange(holder);
            for (T x:holder){
                value = x;
                holder.remove(x);
            }
            System.out.println("Final value "+value);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
class ExchangerDemo{
    static int size = 10;
    static int delay = 5;
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        Exchanger<List<Fat>> xc= new Exchanger<>();
        List<Fat>
                producerList = new CopyOnWriteArrayList<>(),
                consumerList = new CopyOnWriteArrayList<>();
    }
}
