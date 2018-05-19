package com.ct.pattern.simplefactory;

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

class CarSimpleFactory{

    private static final String TOPTYPE = "topCar";
    private static final String MIDTYPE = "midCar";
    private static final String LOWTYPE = "lowCar";

    public static ICar create(String mark){
        ICar iCar = null;
        if(TOPTYPE.equals(mark)){
            iCar = new TopCar();
        }else if(MIDTYPE.equals(mark)){
            iCar = new MidCar();
        }else if(LOWTYPE.equals(mark)){
            iCar = new LowCar();
        }
        return iCar;
    }

    public static void main(String[] args) {

    }
}