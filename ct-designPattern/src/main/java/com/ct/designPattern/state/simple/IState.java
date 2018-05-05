package com.ct.designPattern.state.simple;

/**
 * Created by Herdsric-M-003 on 2018/5/4.
 */
public interface IState {
    void goState();
}

class ConcreteStateA implements IState{
    @Override
    public void goState() {
        System.out.println("This id ConcreteStateA");
    }
}

class ConcreteStateB implements IState{
    @Override
    public void goState() {
        System.out.println("This is ConcreteStateB");
    }
}

class Context{
    private IState state;
    public void setState(IState state){
        this.state = state;
    }
    public void manage(){
        state.goState();
    }
}
