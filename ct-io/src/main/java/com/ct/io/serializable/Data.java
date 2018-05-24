package com.ct.io.serializable;

import java.io.Serializable;

/**
 * Created by Herdsric-M-003 on 2018/5/24.
 */
class Data implements Serializable{
    private int n;
    public Data(int n){
        this.n = n;
    }
    @Override
    public String toString() {
        return Integer.toString(n);
    }
}

