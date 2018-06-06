package com.ct.supervene.carbuilder;

import java.util.concurrent.TimeUnit;

/**
 * Created by Herdsric-M-003 on 2018/6/5.
 */
class ChassisBuilder implements Runnable{
    private CarQueue carQueue;
    private int counter = 0;
    public ChassisBuilder(CarQueue carQueue){this.carQueue = carQueue;}
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(500);
                Car car = new Car(counter++);
                System.out.println("ChassisBuilder created "+car);
                carQueue.put(car);
            }
        }catch (InterruptedException e){
            System.out.println("Interrupted:ChassisBuilder");
        }
        System.out.println("ChassisBuilder off");
    }
}
