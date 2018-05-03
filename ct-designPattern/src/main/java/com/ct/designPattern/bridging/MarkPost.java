package com.ct.designPattern.bridging;

/**
 * Created by Herdsric-M-003 on 2018/5/2.
 */
public class MarkPost implements IPost{
    @Override
    public void post() {
        System.out.println("This is mark post!");
    }
}
