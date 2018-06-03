package com.ct.supervene.queue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2018/6/2.
 */
public class ToastOMatic {
    public static void main(String[] args) throws Exception{
        ToastQueue dryQueue = new ToastQueue(),
                bufferedQueue = new ToastQueue(),
                jammedQueue = new ToastQueue();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Toaster(dryQueue));
        exec.execute(new Butterer(dryQueue,bufferedQueue));
        exec.execute(new Jammer(bufferedQueue,jammedQueue));
        exec.execute(new Eater(jammedQueue));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
