package com.ct.chapter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Herdsric-M-003 on 2018/4/19.
 */
public class ChannelCopy {
    private static final int BSIZE = 1024;
    public void copy(String fileName1,String fileName2){
        try {
            FileChannel in = new FileInputStream(fileName1).getChannel();
            FileChannel out = new FileOutputStream(fileName2).getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
            while (in.read(buffer) != -1){
                buffer.flip();
                out.write(buffer);
                buffer.clear();
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public void transferTo(String fileName1,String fileName2){
        try {
            FileChannel in = new FileInputStream(fileName1).getChannel();
            FileChannel out = new FileOutputStream(fileName2).getChannel();
            in.transferTo(0,in.size(),out);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
