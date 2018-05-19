package com.ct.pattern.factory;

/**
 * Created by dell on 2018/5/15.
 */
interface ICar {
    String name();
}

class TopCar implements ICar{
    private final String name="高档小汽车";
    @Override
    public String name() {
        return name;
    }
}

class MidCar implements ICar{
    private final String name="中档小汽车";
    @Override
    public String name() {
        return name;
    }
}

class LowCar implements ICar{
    private final String name="低档小汽车";
    @Override
    public String name() {
        return name;
    }
}

abstract class AbstractFactory{
    public abstract ICar createCar();
}

class TopFactory extends AbstractFactory{
    @Override
    public ICar createCar() {
        return new TopCar();
    }
}

class MidFactory extends AbstractFactory{

    @Override
    public ICar createCar() {
        return new MidCar();
    }
}

class LowFactory extends AbstractFactory{

    @Override
    public ICar createCar() {
        return new LowCar();
    }
}