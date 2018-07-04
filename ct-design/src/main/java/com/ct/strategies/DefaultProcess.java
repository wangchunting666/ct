package com.ct.strategies;

/**
 * Created by Herdsric-M-003 on 2018/7/4.
 */
public class DefaultProcess implements IProcess{
    @Override
    public void process(IStrategies strategies) {
        strategies.execute();
    }

    public static void main(String[] args) {
        IProcess p = new DefaultProcess();
        p.process(new DefaultStrategies());
    }
}
