package com.ct.em.Statement;

/**
 * Created by Herdsric-M-003 on 2018/5/25.
 */
class VendingMachine {
    private static State state = State.RESTING;
    private static int amount = 0;
    enum StateDuration{TRANSIENT}
    enum State{
        RESTING{

        };
        private boolean isTransient = false;
        State(){}
        State(StateDuration trans){isTransient = true;}
        void next(Input input){
            throw new RuntimeException("Only call next(Input) for non-transient states");
        }
        void next(){
            throw new RuntimeException("Only call next() for non-transient states");
        }
        void output(){
            System.out.println(amount);
        }
    }
}
