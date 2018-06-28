package com.ct.ehcache;

/**
 * Created by Herdsric-M-003 on 2018/6/14.
 */
public class Dog {
    public Dog(long size,String name,short number){
        this.size = size;
        this.name = name;
        this.number = number;
    }
    private long size;
    private String name;
    private short number;

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(short number) {
        this.number = number;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public short getNumber() {
        return number;
    }
}
