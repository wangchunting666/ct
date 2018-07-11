package com.ct.util.code.base;

import java.util.Calendar;

/**
 * Created by Herdsric-M-003 on 2018/7/11.
 */
public class NumberCode extends AbstractCode{
    public int seed = 11;
    @Override
    public synchronized String create() {
        String time = String.valueOf(Calendar.getInstance().getTimeInMillis());
        time = time.substring(time.length()-10);
        if(seed < 11 || seed > 99){
            seed = 11;
        }
        time = time + seed;
        seed++;
        return time;
    }
}
