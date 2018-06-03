package com.ct.supervene.end;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2018/5/30.
 */
public class Interrupting {
    private static ExecutorService exec = Executors.newCachedThreadPool();
    static void test(Runnable run) throws InterruptedException{
        Future<?> f = exec.submit(run);
        TimeUnit.MILLISECONDS.sleep(100);
        //System.out.println("Interrupting " + f.getClass().getName());
        //f.cancel(true);
        //System.out.println("Interrupt sent to "+f.getClass().getName());
    }

    public static void main(String[] args) throws Exception{
        //test(new SleepBlocked());
        //test(new IOBlocked(System.in));
        test(new SynchronizedBlocked());
    }
}
