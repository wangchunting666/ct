package com.ct.state.simple;

/**
 * Created by dell on 2018/5/20.
 */
interface IState {
    void goState();
}
class ConcreteStateA implements IState{
    @Override
    public void goState() {
        System.out.println("This is ConcreteStateA");
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