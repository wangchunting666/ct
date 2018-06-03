package com.ct.supervene.end;

import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2018/5/31.
 */
class NeedsCleanup {
    private final int id;
    public NeedsCleanup(int ident){
        id = ident;
        System.out.println("NeedsCleanup "+id);
    }
    public void cleanup(){
        System.out.println("Cleaning up "+id);
    }
}

class Blocked3 implements Runnable{
    private volatile double d = 0.0;
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                //points1
                NeedsCleanup n1 = new NeedsCleanup(1);
                try {
                    System.out.println("Sleeping");
                    TimeUnit.SECONDS.sleep(1);
                    NeedsCleanup n2 = new NeedsCleanup(2);
                    try {
                        System.out.println("Calculating");
                        for (int i=1; i<250000;i++){
                            d = d+(Math.PI + Math.E)/d;
                        }
                        System.out.println("Finished time-consuming operation");
                    }finally {
                        n2.cleanup();
                    }
                }finally {
                    n1.cleanup();
                }
            }
        }catch (InterruptedException e){
            System.out.println("Exitting via InterruptedException");
        }
    }
}
