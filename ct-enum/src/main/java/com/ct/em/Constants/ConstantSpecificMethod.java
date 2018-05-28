package com.ct.em.Constants;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Herdsric-M-003 on 2018/5/25.
 */
enum ConstantSpecificMethod {
    DATE_TIME{
        @Override
        String getInfo() {
            return DateFormat.getDateInstance().format(new Date());
        }
    },
    CLASSPATH{
        @Override
        String getInfo() {
            return System.getenv("CLASSPATH");
        }
    },
    VERSION{
        @Override
        String getInfo() {
            return System.getProperty("java.version");
        }
    };
    abstract String getInfo();

    public static void main(String[] args) {
        for(ConstantSpecificMethod method:values()){
            System.out.println(method.getInfo());
        }
    }
}
