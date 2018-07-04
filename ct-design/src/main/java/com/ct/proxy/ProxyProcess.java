package com.ct.proxy;

/**
 * Created by Herdsric-M-003 on 2018/7/4.
 */
class ProxyProcess implements IProcess{
    private IProcess process;
    public ProxyProcess(IProcess process){
        this.process = process;
    }
    @Override
    public void process() {
        process.process();
    }
}
