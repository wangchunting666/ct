package com.ct.build.application;

/**
 * Created by dell on 2018/5/16.
 */
interface IBuild<T> {
    T create();
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
class Product{
    private Unit1 u1;
    private Unit2 u2;
    private Unit3 u3;
    public void setU1(Unit1 u1) {
        this.u1 = u1;
    }
    public void setU2(Unit2 u2) {
        this.u2 = u2;
    }
    public void setU3(Unit3 u3) {
        this.u3 = u3;
    }
}

class Builder implements IBuild<Product>{
    private Product pt = new Product();
    @Override
    public Product create() {
        createUnit1();
        createUnit2();
        createUnit3();
        return composite();
    }
    private void createUnit1(){
        pt.setU1(new Unit1());
    }
    private void createUnit2(){
        pt.setU2(new Unit2());
    }
    private void createUnit3(){
        pt.setU3(new Unit3());
    }
    private Product composite(){
        return pt;
    }
}


