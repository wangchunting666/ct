package com.ct.build.self;

/**
 * Created by dell on 2018/5/19.
 */
abstract class Product {
    private Unit1 u1;
    private Unit2 u2;
    private Unit3 u3;
    public abstract void unit1();
    public abstract void unit2();
    public abstract void unit3();
    public abstract void composite();
}
class Unit1{
    public String name = "u1";
}
class Unit2{
    public String name = "u2";
}
class Unit3{
    public String name = "u3";
}
