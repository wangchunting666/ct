package com.ct.io.zip;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.zip.GZIPOutputStream;

/**
 * Created by Herdsric-M-003 on 2018/5/23.
 */
class GZIPCompress {
    private static final String FROM = "D:\\学习\\api\\pdf书籍\\Java设计模式深入研究.pdf";
    private static final String TO = "D:\\学习\\api\\pdf书籍\\Java设计模式深入研究.gz";
    public static void main(String[] args) throws Exception{
        BufferedReader br1 = new BufferedReader(new FileReader(FROM));
        BufferedOutputStream bos1 = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(TO)));
        System.out.println("Writting file");
        int c;
        while ((c=br1.read()) != -1){
            bos1.write(c);
        }
        br1.close();
        bos1.close();

        System.out.println("Reading file");
        BufferedReader br2 = new BufferedReader(new FileReader(TO));
        String s;
        while ((s = br2.readLine()) != null){
            System.out.println( new String(s.getBytes("UTF-8"),"UTF-8"));
        }
    }
}
