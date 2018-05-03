package com.ct.designPattern.bridging.application;

/**
 * Created by Herdsric-M-003 on 2018/5/3.
 */
public interface IRead<T> {
    T read() throws Exception;
}

class TextRead implements IRead<String>{
    private AbstractStream abstractStream;
    public TextRead(AbstractStream abstractStream){
        this.abstractStream = abstractStream;
    }
    @Override
    public String read() throws Exception {
        byte[] buf = abstractStream.readByte();
        String s = new String(buf);
        return s;
    }
}

class ImgRead implements IRead<byte[]>{
    private AbstractStream abstractStream;
    public ImgRead(AbstractStream abstractStream){
        this.abstractStream = abstractStream;
    }
    @Override
    public byte[] read() throws Exception {
        return abstractStream.readByte();
    }
}


