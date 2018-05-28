package com.ct.em.Constants;

import java.util.EnumSet;

/**
 * Created by Herdsric-M-003 on 2018/5/25.
 */
class CarWash {
    public enum Cycle{
        UNDERBODY{
            @Override
            void action() {
                System.out.println("UnderBody");
            }
        },
        WHEELWASH{
            @Override
            void action() {
                System.out.println("WheelWash");
            }
        },
        PREWASH{
            @Override
            void action() {
                System.out.println("PreWash");
            }
        },
        BASIC{
            @Override
            void action() {
                System.out.println("Basic");
            }
        },
        HOTWAX{
            @Override
            void action() {
                System.out.println("Applying hot max");
            }
        },
        RINSE{
            @Override
            void action() {
                System.out.println("Rinsing");
            }
        },
        BLOWDRY{
            @Override
            void action() {
                System.out.println("Blowing dry");
            }
        };
        abstract void action();
    }

    EnumSet<Cycle> cycles = EnumSet.of(Cycle.BASIC,Cycle.RINSE);
    public void add(Cycle cycle){
        cycles.add(cycle);
    }
    public void WashCar(){
        for(Cycle cycle:cycles){cycle.action();}
    }

    @Override
    public String toString() {
        return cycles.toString();
    }

    public static void main(String[] args) {
        CarWash carWash = new CarWash();
        System.out.println(carWash);
        carWash.WashCar();
    }
}
