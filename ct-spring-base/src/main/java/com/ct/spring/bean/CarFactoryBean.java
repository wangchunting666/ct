package com.ct.spring.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created by dell on 2018/6/27.
 */
public class CarFactoryBean implements FactoryBean<Car>{
    private String carInfo;
    @Override
    public Car getObject() throws Exception {
        Car car = new Car();
        String[] infos = carInfo.split(",");
        car.setMaxSpeed(Integer.valueOf(infos[0]));
        car.setBrand(infos[1]);
        car.setPrice(Double.valueOf(infos[2]));
        return car;
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    public String getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
    }
}
