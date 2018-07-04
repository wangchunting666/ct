package com.ct.factory;

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

interface IBus{
    String name();
}

class TopBus implements IBus{
    private final String name="高档汽车";
    @Override
    public String name() {
        return name;
    }
}

class MidBus implements IBus{
    private final String name="中档汽车";
    @Override
    public String name() {
        return name;
    }
}

class LowBus implements IBus{
    private final String name="低档汽车";
    @Override
    public String name() {
        return name;
    }
}

abstract class AbstractFactory{
    public abstract ICar createCar();
    public abstract IBus createBus();
}

class TopFactory extends AbstractFactory{

    @Override
    public ICar createCar() {
        return new TopCar();
    }

    @Override
    public IBus createBus() {
        return new TopBus();
    }
}

class MidFactory extends AbstractFactory{

    @Override
    public ICar createCar() {
        return new MidCar();
    }

    @Override
    public IBus createBus() {
        return new MidBus();
    }
}

class LowFactory extends AbstractFactory{

    @Override
    public ICar createCar() {
        return new LowCar();
    }

    @Override
    public IBus createBus() {
        return new LowBus();
    }
}