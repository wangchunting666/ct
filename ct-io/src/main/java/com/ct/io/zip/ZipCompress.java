package com.ct.io.zip;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.*;

/**
 * Created by Herdsric-M-003 on 2018/5/24.
 */
class ZipCompress {
    private static final String file = "D:\\学习\\api\\pdf书籍";
    public static void main(String[] args) throws Exception{
        FileOutputStream fos1 = new FileOutputStream("test.zip");
        CheckedOutputStream com1 = new CheckedOutputStream(fos1,new Adler32());
        ZipOutputStream zos1 = new ZipOutputStream(com1);
        BufferedOutputStream bos1 = new BufferedOutputStream(zos1);
        zos1.setComment("A test of Java Zipping");

        File[] fs1 = new File(file).listFiles();
        for (File f:fs1){
            System.out.println("Writing file "+f.getName());
            BufferedReader br1 = new BufferedReader(new FileReader(f));
            zos1.putNextEntry(new ZipEntry(file+"\\"+f.getName()));
            int c;
            while ((c=br1.read()) != -1){
                bos1.write(c);
            }
            br1.close();
            bos1.flush();
        }
        bos1.close();

        System.out.println("Checksum:"+com1.getChecksum().getValue());


        System.out.println("Reading file");
        FileInputStream fis1 = new FileInputStream("test.zip");
        CheckedInputStream cis1 = new CheckedInputStream(fis1,new Adler32());
        ZipInputStream zis1 = new ZipInputStream(cis1);
        BufferedInputStream bis1 = new BufferedInputStream(zis1);

        ZipEntry ze;
        while ((ze = zis1.getNextEntry()) != null){
            System.out.println("Reading file"+ze);
            int x;
            while ((x = bis1.read()) != -1){
                System.out.println(x);
            }
        }
        System.out.println("Checksum:"+com1.getChecksum().getValue());
        bis1.close();

        ZipFile zf = new ZipFile("test.zip");
        Enumeration e = zf.entries();
        while (e.hasMoreElements()){
            ZipEntry ze1 = (ZipEntry)e.nextElement();
            System.out.println("File:"+ze1);
        }
    }
}
