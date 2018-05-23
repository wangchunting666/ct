package com.ct.nio.channels;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Herdsric-M-003 on 2018/5/23.
 */
class GetChannel {
    private static final int BSIZE = 1024;
    public static void main(String[] args) throws Exception{
        //write text
        FileChannel fileChannel = new FileOutputStream("data.txt").getChannel();
        fileChannel.write(ByteBuffer.wrap("Some text ".getBytes()));
        fileChannel.close();
        //write more
        fileChannel = new RandomAccessFile("data.txt","rw").getChannel();
        fileChannel.position(fileChannel.size());
        fileChannel.write(ByteBuffer.wrap("Some more ".getBytes()));
        fileChannel.close();
        //read file
        fileChannel = new FileInputStream("data.txt").getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(BSIZE);
        fileChannel.read(byteBuffer);
        byteBuffer.flip();
        while (byteBuffer.hasRemaining()){
            System.out.println((char)byteBuffer.get());
        }
    }
}
