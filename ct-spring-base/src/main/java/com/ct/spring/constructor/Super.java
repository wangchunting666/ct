package com.ct.spring.constructor;

/**
 * Created by dell on 2018/6/19.
 */
public class Super extends SuperSuper{
    public Super(){
        System.out.println("This is default super constructor!");
    }
    public Super(String name){
        System.out.println("This is "+name+" super contructor!");
    }
}

