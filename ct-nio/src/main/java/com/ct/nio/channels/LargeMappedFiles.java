package com.ct.nio.channels;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Herdsric-M-003 on 2018/5/23.
 */
class LargeMappedFiles {
    private static final int length = 0x8FFFFFF;//128MB
    private static final String file = "test.dat";
    public static void main(String[] args) throws Exception{
        MappedByteBuffer mbb = new RandomAccessFile(file,"rw").getChannel().
                map(FileChannel.MapMode.READ_WRITE,0,length);
        for(int i=0;i<length;i++){
            mbb.put((byte)'x');
        }
        System.out.println("print writting");
        for (int i=length/2; i < length/2 + 6; i++){
            System.out.println((char)mbb.get(i));
        }
    }
}
