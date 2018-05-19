package com.ct.build.simple;

/**
 * Created by dell on 2018/5/16.
 */
interface IBuild {
    void createUnit1();
    void createUnit2();
    void createUnit3();
    Product composite();
}
interface Unit1{
    String name();
}
interface Unit2{
    String name();
}
interface Unit3{
    String name();
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
class Builder implements IBuild{
    private Product pt = new Product();
    @Override
    public void createUnit1() {
        pt.setU1(
                new Unit1() {
                    @Override
                    public String name() {
                        return "u1";
                    }
                }
        );
    }

    @Override
    public void createUnit2() {
        pt.setU2(
                new Unit2() {
                    @Override
                    public String name() {
                        return "u2";
                    }
                }
        );
    }

    @Override
    public void createUnit3() {
        pt.setU3(
                new Unit3() {
                    @Override
                    public String name() {
                        return "u3";
                    }
                }
        );
    }

    @Override
    public Product composite() {
        createUnit1();
        createUnit2();
        createUnit3();
        return pt;
    }
}

class Director{
    private IBuild build;
    public Director(IBuild build){
        this.build = build;
    }
    public Product build(){
        return build.composite();
    }

    public static void main(String[] args) {
        IBuild bd = new Builder();
        Director director = new Director(bd);
        Product pt = director.build();
        System.out.println(pt);
    }
}

