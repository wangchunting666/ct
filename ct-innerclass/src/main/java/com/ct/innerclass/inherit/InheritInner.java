package com.ct.innerclass.inherit;

/**
 * Created by Herdsric-M-003 on 2018/6/5.
 */
public class InheritInner extends WithInner.Inner{
    InheritInner(WithInner withInner){
        withInner.super();
    }
    public static void main(String[] args) {
        WithInner withInner = new WithInner();
        new InheritInner(withInner);
    }
}
