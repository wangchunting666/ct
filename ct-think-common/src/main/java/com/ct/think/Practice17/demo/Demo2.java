package com.ct.think.Practice17.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Herdsric-M-003 on 2018/4/9.
 */
public class Demo2 {
    class StringAddress{
        private String s;
        public StringAddress(String s){
            this.s = s;
        }
        @Override
        public String toString() {
            return super.toString()+" "+s;
        }
    }

    public static void main(String[] args) {
        Demo2 demo = new Demo2();
        List<StringAddress> list = new ArrayList<>(
                Collections.nCopies(4,demo.new StringAddress("hello"))
        );
        System.out.println(list);
    }
}
