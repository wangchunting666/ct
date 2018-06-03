package com.ct.supervene.queue;

import com.ct.supervene.simple.LiftOff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.*;

/**
 * Created by dell on 2018/6/2.
 */
public class TestBlockingQueues {
    static void getKey(){
        try {
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    static void getKey(String msg){
        System.out.println(msg);
        getKey();
    }
    private static void test(String msg, BlockingQueue<LiftOff> queue) throws Exception{
        System.out.println(msg);
        LiftOffRuner runner = new LiftOffRuner(queue);
        Thread thread = new Thread(runner);
        thread.start();
        for(int i=0; i<5; i++){
            System.out.println("填充LiftOff");
            runner.add(new LiftOff(5));
            TimeUnit.SECONDS.sleep(1);
        }
        getKey("Press 'Enter' ("+msg+")");
        thread.interrupt();
        System.out.println("Finished "+msg+" test");
    }
    public static void main(String[] args) throws Exception{
        //test("LinkBlockingQueue",new LinkedBlockingQueue<>());
        //test("ArrayBlockingQueue",new ArrayBlockingQueue<LiftOff>(3));
        test("SynchronousQueue",new SynchronousQueue<>());

    }
}
