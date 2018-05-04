package com.ct.designPattern.state.application;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Herdsric-M-003 on 2018/5/4.
 */
public interface ICellState {
    float NORMAL_LIMIT = 0;
    float STOP_LIMIT = -1;
    float COST_MINUTE = 0.20f;
    public boolean phone(CellContext ct);
}

class NormalState implements ICellState{
    @Override
    public boolean phone(CellContext ct) {
        System.out.println(ct.name+":手机处于正常状态");
        int minute = (int)(Math.random()*10+1);
        ct.cost(minute);
        return false;
    }
}

class OverDrawState implements ICellState{
    @Override
    public boolean phone(CellContext ct) {
        System.out.println(ct.name+":手机处于欠费状态，请及时缴费");
        int minute = (int)(Math.random()*10+1);
        ct.cost(minute);
        return false;
    }
}

class StopState implements ICellState{
    @Override
    public boolean phone(CellContext ct) {
        System.out.println(ct.name+":手机处于停机状态，请及时缴费");
        return false;
    }
}

class CellContext{
    String strPhone;
    String name;
    float price;

    public CellContext(String strPhone,String name,float price){
        this.strPhone = strPhone;
        this.name = name;
        this.price = price;
    }

    public void save(float price){
        this.price += price;
    }

    public void cost(int minute){
        this.price -= ICellState.COST_MINUTE*minute;
    }

    public boolean call(){
        ICellState state = null;
        if(price > ICellState.NORMAL_LIMIT){
            state = new NormalState();
        }else if(price < ICellState.STOP_LIMIT){
            state = new StopState();
        }else{
            state = new OverDrawState();
        }
        state.phone(this);
        return true;
    }

    public static void main(String[] args) {
        CellContext c = new CellContext("13856975423","jin",1);
        c.call();
        c.call();
        c.save(4);
        c.call();
    }
}

class Manage{
    private Map<String,CellContext> map = new HashMap<>();
    public boolean regist(CellContext ct){
        map.put(ct.strPhone,ct);
        return true;
    }
    public void save(String strPhoneNo,float money){
        map.get(strPhoneNo).save(money);
    }
    public boolean phone(String strPhoneNo){
        map.get(strPhoneNo).call();
        return true;
    }
}
