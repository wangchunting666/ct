package com.ct.chapter;

import java.io.*;

/**
 * Created by Herdsric-M-003 on 2018/4/18.
 */
public class BasicFileOutPut {
    private static String file = "BasicFileOutPut.out";
    public static void fileOutPut(String filename) throws Exception{
        BufferedReader reader = new BufferedReader(
                new StringReader(
                        BufferInputFile.read(filename)
                )
        );
        PrintWriter out = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(file)
                )
        );
        int lineCount = 1;
        String s;
        while ((s=reader.readLine()) != null){
            out.println(lineCount++ + ":" + s);
        }
        out.close();
    }
}
