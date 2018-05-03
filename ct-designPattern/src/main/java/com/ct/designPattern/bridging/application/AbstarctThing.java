package com.ct.designPattern.bridging.application;

/**
 * Created by Herdsric-M-003 on 2018/5/3.
 */
public abstract class AbstarctThing {
    private IRead read;
    public AbstarctThing(IRead read){
        this.read = read;
    }
    Object read() throws Exception{
        return read.read();
    }
}

class NativeFile extends AbstarctThing{

    public NativeFile(IRead read) {
        super(read);
    }

}

class UrlFile extends AbstarctThing{

    public UrlFile(IRead read) {
        super(read);
    }
}