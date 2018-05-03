package com.ct.designPattern.generate;

/**
 * Created by Herdsric-M-003 on 2018/4/28.
 */
public class Director {
    private IBuild<Product> builder;
    public Director(IBuild builder){
        this.builder = builder;
    }
    public Product build(){
        return builder.composite();
    }

    public static void main(String[] args) {
        Director director = new Director(new Builder());
        Product product = director.build();
    }
}
