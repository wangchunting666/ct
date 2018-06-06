package com.ct.supervene.carbuilder;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by Herdsric-M-003 on 2018/6/5.
 */
class Assembler implements Runnable{
    private CarQueue chassisQueue,finishingQueue;
    private Car car;
    private CyclicBarrier barrier = new CyclicBarrier(4);
    @Override
    public void run() {

    }
}
