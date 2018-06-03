package com.ct.supervene.component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by dell on 2018/6/3.
 */
class Horse implements Runnable{
    private static int counter = 0;
    private final int id = counter++;
    private int strides = 0;
    private static Random random = new Random(47);
    private CyclicBarrier cyclicBarrier;

    public synchronized int getStrides() {
        return strides;
    }

    public Horse(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public String toString() {
        return "Horse "+id;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                synchronized (this){
                    strides = random.nextInt(3);
                }
                cyclicBarrier.await();
            }
        }catch (InterruptedException e){
            System.out.println("Horse InterruptedException");
        }catch (BrokenBarrierException e) {
            System.out.println("Horse BrokenBarrierException");
        }
    }
    public String tracks(){
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<getStrides();i++){
            sb.append("*");
        }
        sb.append(id);
        return sb.toString();
    }
}

class HorseRace{
    static final int FINISH_LINE = 75;
    private List<Horse> horses = new ArrayList<>();
    private ExecutorService exec = Executors.newCachedThreadPool();
    private CyclicBarrier cyclicBarrier;
    public HorseRace(int nHorse,final int pause){
        cyclicBarrier = new CyclicBarrier(nHorse, new Runnable() {
            @Override
            public void run() {
                StringBuilder sb = new StringBuilder();
                for(int i=0; i<FINISH_LINE; i++){
                    sb.append("=");
                }
                System.out.println(sb);
                for (Horse horse:horses){
                    System.out.println(horse.tracks());
                }
                for (Horse horse:horses){
                    if(horse.getStrides() >= FINISH_LINE){
                        System.out.println(horse + "won!");
                        exec.shutdownNow();
                        return;
                    }
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(pause);
                }catch (InterruptedException e){
                    System.out.println("barrier-action sleep interrupt");
                }
            }
        });
        for (int i=0; i<nHorse; i++){
            Horse horse = new Horse(cyclicBarrier);
            horses.add(horse);
            exec.execute(horse);
        }
    }

    public static void main(String[] args) {
        int nHorse = 7;
        int pause = 200;
        new HorseRace(nHorse,pause);
    }
}