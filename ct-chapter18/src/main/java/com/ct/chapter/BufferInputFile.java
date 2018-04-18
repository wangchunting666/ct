package com.ct.chapter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FileReader;

/**
 * Created by Herdsric-M-003 on 2018/4/18.
 */
public class BufferInputFile {
    private static Logger logger = LogManager.getLogger(BufferInputFile.class.getName());
    public static String read(String filename) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder builder = new StringBuilder();
        while ((s = bufferedReader.readLine()) != null){
            builder.append(s+"\n");
            logger.info(s);
        }
        bufferedReader.close();
        return builder.toString();
    }

    public static void memoryInput(String filename) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        int i;
        while ((i=bufferedReader.read()) != -1){
            logger.info((char)i);
        }
        bufferedReader.close();
    }

    public static void formatInput(String filename) throws Exception{
        DataInputStream dis = new DataInputStream(
                new ByteArrayInputStream(BufferInputFile.read(filename).getBytes()));
        while (dis.available() != 0){
            logger.info((char)dis.readByte());
        }
    }
}
