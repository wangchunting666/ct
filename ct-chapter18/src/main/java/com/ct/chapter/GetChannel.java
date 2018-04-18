package com.ct.chapter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Herdsric-M-003 on 2018/4/18.
 */
public class GetChannel {
    private static Logger logger = LogManager.getLogger(GetChannel.class.getName());
    private static final int BSIZE = 1024;
    public static void channel(){
        try {
            FileChannel channel = new FileOutputStream("data.txt").getChannel();
            channel.write(ByteBuffer.wrap("Some Text".getBytes()));
            channel.close();

            channel = new RandomAccessFile("data.txt","rw").getChannel();
            channel.position(channel.size());
            channel.write(ByteBuffer.wrap("Some Text".getBytes()));
            channel.close();

            channel = new FileInputStream("data.txt").getChannel();
            ByteBuffer buff = ByteBuffer.allocate(BSIZE);
            channel.read(buff);
            buff.flip();
            while (buff.hasRemaining()){
                System.out.println((char)buff.get());
            }
            channel.close();
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
