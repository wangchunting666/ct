package com.ct.io.zip;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by Herdsric-M-003 on 2018/5/24.
 */
class ZipUtil {
    private static final int BSIZE = 1024;
    private static final String source = "D:\\学习\\test\\";
    private static final String out = "D:\\学习\\test\\test.zip";
    private static void zip(String zip,String source) throws Exception{
        System.out.println("压缩中...");
        File sf = new File(source);
        FileOutputStream fos = new FileOutputStream(zip);
        ZipOutputStream zos = new ZipOutputStream(fos);
        BufferedOutputStream bos = new BufferedOutputStream(zos);
        compress(sf,zos,bos,sf.getName());
        bos.close();
        zos.close();
        fos.close();
        System.out.println("压缩完成");
    }

    private static void compress(File sf,ZipOutputStream zos,BufferedOutputStream bos,String name) throws Exception {
        if(sf.isDirectory()) {
            zos.putNextEntry(new ZipEntry(name + "/"));
            File[] files = sf.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return !pathname.getName().endsWith(".zip");
                }
            });
            for (File f:files) compress(f,zos,bos,name + "/" + f.getName());
        }else {
            zos.putNextEntry(new ZipEntry(name));
            FileInputStream fis = new FileInputStream(sf);
            BufferedInputStream bis = new BufferedInputStream(fis);
            byte[] bytes = new byte[BSIZE];
            int i;
            while ((i=bis.read(bytes,0,BSIZE)) != -1){
                bos.write(bytes,0,i);
            }
            bis.close();
            fis.close();
        }
    }

    public static void main(String[] args) throws Exception{
        zip(out,source);
    }
}
