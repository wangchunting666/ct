package com.ct.nio.channels;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.IntBuffer;

/**
 * Created by Herdsric-M-003 on 2018/5/23.
 */
class DoubleBufferDemo {
    private static final int BSIZE = 1024;
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(BSIZE);
        DoubleBuffer doubleBuffer = byteBuffer.asDoubleBuffer();
        doubleBuffer.put(12.56982d);
        doubleBuffer.flip();
        System.out.println(doubleBuffer.get());
    }
}
