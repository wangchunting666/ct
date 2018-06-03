package com.ct.supervene.piped;

import java.io.IOException;
import java.io.PipedWriter;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2018/6/2.
 */
public class Sender implements Runnable{
    private Random random = new Random(47);
    private PipedWriter pipedWriter = new PipedWriter();
    public PipedWriter getPipedWriter() {
        return pipedWriter;
    }
    @Override
    public void run() {
        try {
            while (true) {
                for (char c = 'A'; c < 'z'; c++) {
                    pipedWriter.write(c);
                    TimeUnit.MILLISECONDS.sleep(random.nextInt(500));
                }
            }
        }catch (IOException e){
            System.out.println("Sender IOException");
        }catch (InterruptedException e){
            System.out.println("Sender InterruptedException");
        }

    }
}
