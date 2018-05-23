package com.ct.nio.channels;

import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * Created by Herdsric-M-003 on 2018/5/23.
 */
class FileLocking {
    private static final String file = "file.txt";
    public static void main(String[] args) throws Exception{
        FileOutputStream fos = new FileOutputStream(file);
        FileLock lock = fos.getChannel().tryLock();
        if(lock != null){
            System.out.println("lock file");
            TimeUnit.MILLISECONDS.sleep(10000);
            lock.release();
            System.out.println("release lock");
        }
        fos.close();
    }
}
