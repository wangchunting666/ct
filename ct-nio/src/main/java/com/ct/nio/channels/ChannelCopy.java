package com.ct.nio.channels;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Herdsric-M-003 on 2018/5/23.
 */
class ChannelCopy {
    private static final String from = "D:\\学习\\api\\pdf书籍\\Spring+Cloud微服务实战_PDF电子书下载+高清+带索引书签目录_翟永超%28著%29++%40www.java1234.com.pdf";
    private static final String to = "D:\\学习\\api\\pdf书籍\\Spring+Cloud微服务实战.pdf";
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception{
        FileChannel in = new FileInputStream(from).getChannel();
        FileChannel out = new FileOutputStream(to).getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(BSIZE);
        while (in.read(byteBuffer) != -1){
            byteBuffer.flip();
            out.write(byteBuffer);
            byteBuffer.clear();
        }
        in.close();
        out.close();
    }
}
