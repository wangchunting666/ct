package com.ct.nio.channels;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * Created by Herdsric-M-003 on 2018/5/23.
 */
class LockingMappedFiles {
    private static int LENGTH = 0x8FFFFFF;//128M
    private static FileChannel fc;
    private static final String file = "test.dat";
    public static void main(String[] args) throws Exception{
        fc = new RandomAccessFile(file,"rw").getChannel();
        MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE,0,LENGTH);
        new LockAndModify(mbb,0,0+LENGTH/3);
        new LockAndModify(mbb,LENGTH/2,LENGTH/2+LENGTH/3);
    }

    private static class LockAndModify extends Thread{
        private ByteBuffer buff;
        private int start,end;
        public LockAndModify(ByteBuffer buff,int start,int end){
            this.start = start;
            this.end = end;
            buff.limit(end);
            buff.position(start);
            this.buff = buff.slice();
            start();
        }

        @Override
        public void run() {
            try {
                FileLock fl1 = fc.lock(start,end,false);
                System.out.println("Locked:"+start+" to"+end);
                while (buff.position() < buff.limit()-1){
                    buff.put((byte)(buff.get()+1));
                }
                fl1.release();
                System.out.println("Release:"+start+" to"+end);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
