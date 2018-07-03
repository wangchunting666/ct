package com.ct.spring.constructor;

/**
 * Created by dell on 2018/6/19.
 */
public class Children extends Super{
    public Children(){
        this("234");
        System.out.println("This is default children constructor!");
    }
    public Children(String name){
        super(name);
        System.out.println("This is "+name+" children contructor!");
    }

    public static void main(String[] args) {
        new Children();
    }
}
