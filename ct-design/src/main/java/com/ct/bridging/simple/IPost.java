package com.ct.bridging.simple;

/**
 * Created by dell on 2018/5/19.
 */
interface IPost {
    void post();
}
class simplePost implements IPost{
    @Override
    public void post() {
        System.out.println("平邮");
    }
}
class MarkPost implements IPost{
    @Override
    public void post() {
        System.out.println("挂号");
    }
}

abstract class AbstractThing{
    private IPost post;
    public AbstractThing(IPost post){
        this.post = post;
    }
    public void post(){
        post.post();
    }
}

class Letter extends AbstractThing{
    public Letter(IPost post) {
        super(post);
    }
}

class Parcel extends AbstractThing{
    public Parcel(IPost post) {
        super(post);
    }
}


