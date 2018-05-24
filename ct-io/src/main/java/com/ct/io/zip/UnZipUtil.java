package com.ct.io.zip;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by Herdsric-M-003 on 2018/5/24.
 */
public class UnZipUtil {
    private static final int BSIZE = 1024;
    private static final String source = "D:\\学习\\test\\test.zip";
    private static final String to = "D:\\学习\\test\\";
    private static void unZip(String source,String to) throws Exception{
        FileInputStream fis = new FileInputStream(source);
        ZipInputStream zis = new ZipInputStream(fis);
        BufferedInputStream bis = new BufferedInputStream(zis);
        byte[] bytes = new byte[BSIZE];
        ZipEntry entry;
        while ((entry = zis.getNextEntry()) != null){
            if(!entry.isDirectory()){
                FileOutputStream fos = new FileOutputStream(to+entry.getName());
                BufferedOutputStream bos = new BufferedOutputStream(fos);

                int i=0;
                while ((i=bis.read(bytes,0,BSIZE)) != -1) bos.write(bytes,0,i);

                bos.close();
                fos.close();
            }else{
                File fl = new File(to+entry.getName());
                if(!fl.exists()) fl.mkdirs();
            }
        }
        bis.close();
        zis.close();
        fis.close();
    }

    public static void main(String[] args) throws Exception{
        unZip(source,to);
    }
}
