package com.ct.designPattern.bridging.simle;

/**
 * Created by Herdsric-M-003 on 2018/5/2.
 */
public abstract class AbstarctThing {
    private IPost obj;
    public AbstarctThing(IPost obj){this.obj = obj;}
    public void post(){obj.post();}
}
