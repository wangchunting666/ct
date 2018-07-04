package com.ct.supervene.end;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2018/5/30.
 */
public class CloseResource {
    public static void main(String[] args) throws Exception{
        ExecutorService exec = Executors.newCachedThreadPool();
        ServerSocket socket = new ServerSocket(8080);
        InputStream socketInput = new Socket("localhost",8080).getInputStream();
        //exec.execute(new IOBlocked(socketInput));
        exec.execute(new IOBlocked(System.in));
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("shutting down all threads");
        exec.shutdownNow();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Closing" + socketInput.getClass().getName());
        //socketInput.close();
        System.out.println("closing" + System.in.getClass().getName());
        System.in.close();
    }
}