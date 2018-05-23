package com.ct.nio.channels;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * Created by Herdsric-M-003 on 2018/5/23.
 */
public class BufferToText {
    private static final int BSIZE = 1024;
    private static final String toFile1 = "BufferToText1.txt";
    private static final String toFile2 = "BufferToText2.txt";
    public static void main(String[] args) throws Exception{
        FileChannel fc = new FileOutputStream(toFile1).getChannel();
        fc.write(ByteBuffer.wrap("Some text ".getBytes()));
        fc.close();

        fc = new FileInputStream(toFile1).getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(BSIZE);
        fc.read(byteBuffer);
        fc.close();

        byteBuffer.flip();
        System.out.println(byteBuffer.asCharBuffer());

        byteBuffer.rewind();
        String encoding = System.getProperty("file.encoding");
        System.out.println("解码数据:"+ Charset.forName(encoding).decode(byteBuffer));

        //encode数据
        fc = new FileOutputStream(toFile2).getChannel();
        fc.write(ByteBuffer.wrap("Some text ".getBytes("UTF-16BE")));
        fc.close();

        fc = new FileInputStream(toFile2).getChannel();
        byteBuffer.clear();
        fc.read(byteBuffer);
        byteBuffer.flip();
        System.out.println(byteBuffer.asCharBuffer());
        fc.close();

        fc = new FileOutputStream(toFile2).getChannel();
        byteBuffer.clear();
        byteBuffer.asCharBuffer().put("Some text");
        fc.write(byteBuffer);

        fc = new FileInputStream(toFile2).getChannel();
        byteBuffer.clear();
        fc.read(byteBuffer);
        byteBuffer.flip();
        System.out.println(byteBuffer.asCharBuffer());
    }
}
