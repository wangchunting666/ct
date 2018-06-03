package com.ct.supervene.piped;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * Created by dell on 2018/6/2.
 */
public class Receiver implements Runnable{
    private PipedReader pipedReader;
    public Receiver(Sender sender) throws IOException{
        pipedReader = new PipedReader(sender.getPipedWriter());
    }
    @Override
    public void run() {
        try {
            while (true)
            System.out.println("Read:" + (char)pipedReader.read() + ",");
        }catch (IOException e){
            System.out.println("Receiver Exception");
        }
    }
}
