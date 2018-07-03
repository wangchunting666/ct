package com.source.aop;

/**
 * Created by Herdsric-M-003 on 2018/7/3.
 */
public class TestBean {
    private String testStr = "testStr";

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }

    public String getTestStr() {
        return testStr;
    }

    public void test(){
        System.out.println("test");
    }
}
