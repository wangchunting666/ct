package com.ct.supervene.queue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by dell on 2018/6/2.
 */
class Toast {
    public enum Status{DRY,BUTTERED,JAMMED}
    private Status status = Status.DRY;
    private final int id;
    public Toast(int idn){
        id = idn;
    }
    public void buffer(){
        status = Status.BUTTERED;
    }
    public void jam(){
        status = Status.JAMMED;
    }
    public Status getStatus(){
        return status;
    }
    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return "Toast "+id+": "+status;
    }
}
class ToastQueue extends LinkedBlockingQueue<Toast>{}
