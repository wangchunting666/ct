package com.ct.designPattern.generate;

/**
 * Created by Herdsric-M-003 on 2018/4/28.
 */
public class Builder implements IBuild<Product>{
    private Product product;
    private void createUnit1(){
        product.setUnit1(new Unit(){});
    }
    private void createUnit2(){product.setUnit1(new Unit(){});}
    private void createUnit3(){
        product.setUnit1(new Unit(){});
    }
    @Override
    public Product composite() {
        createUnit1();
        createUnit2();
        createUnit3();
        return product;
    }
}
