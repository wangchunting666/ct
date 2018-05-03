package com.ct.designPattern.bridging.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Herdsric-M-003 on 2018/5/3.
 */
public abstract class AbstractStream {
    protected InputStream in;
    protected int size;
    public byte[] readByte() throws Exception{
        byte[] buf = new byte[size];
        in.read(buf);
        return buf;
    }
    public void close() throws Exception{
        in.close();
    }
}
class NativeStream extends AbstractStream{
    public NativeStream(String strFile) throws Exception{
        File f = new File(strFile);
        size = (int)f.length();
        in = new FileInputStream(f);
    }
}
class UrlStream extends AbstractStream{
    public UrlStream(String strFile) throws Exception{
        URL url = new URL(strFile);
        in = url.openStream();
        HttpURLConnection urlco = (HttpURLConnection)url.openConnection();
        size = urlco.getContentLength();
    }
}
