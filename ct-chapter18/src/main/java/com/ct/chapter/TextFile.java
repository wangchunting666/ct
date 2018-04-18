package com.ct.chapter;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Herdsric-M-003 on 2018/4/18.
 */
public class TextFile extends ArrayList<String>{
    public static String read(String filename){
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader(
                            new File(filename).getAbsoluteFile()
                    )
            );
            try {
                String s;
                while ((s=reader.readLine()) != null){
                    sb.append(s);
                    sb.append("\n");
                }
            }finally {
                reader.close();
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    public static void write(String fileName,String text){
        try {
            PrintWriter pw = new PrintWriter(
                    new File(fileName).getAbsoluteFile()
            );
            try {
                pw.print(text);
            }finally {
                pw.close();
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public TextFile(String fileName,String splitter){
        super(Arrays.asList(read(fileName).split(splitter)));
        if(get(0).equals("")) remove(0);
    }

    public TextFile(String fileName){
        this(fileName,"\n");
    }

    public void write(String fileName){
        try {
            PrintWriter pw = new PrintWriter(
                    new File(fileName).getAbsoluteFile()
            );
            try {
                for(String s:this){
                    pw.println(s);
                }
            }finally {
                pw.close();
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
