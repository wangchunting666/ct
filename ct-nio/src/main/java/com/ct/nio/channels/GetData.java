package com.ct.nio.channels;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Herdsric-M-003 on 2018/5/23.
 */
class GetData {
    private static final int BSIZE = 1024;
    private static final String file = "data1.txt";
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(BSIZE);
        byteBuffer.asCharBuffer().put("Howdy!");
        char c;
        while ((c = byteBuffer.getChar()) != 0){
            System.out.print(c);
        }
    }
}
