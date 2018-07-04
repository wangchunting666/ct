package com.ct.singleton;

/**
 * Created by Herdsric-M-003 on 2018/7/4.
 */
public class Singleton {

}
//饿汉式
class Singleton1{
    private final static Singleton1 INSTANCE = new Singleton1();
    private Singleton1(){}
    public static Singleton1 getInstance(){
        return INSTANCE;
    }
}
class Singleton2{
    private final static Singleton2 INSTANCE;
    static {
        INSTANCE = new Singleton2();
    }
    private Singleton2(){}
    public static Singleton2 getInstance(){
        return INSTANCE;
    }
}
class Singleton3{
    private static volatile Singleton3 instance;
    private Singleton3(){}
    public static Singleton3 getInstance(){
        if(instance != null){
            synchronized (Singleton3.class){
                if(instance != null){
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}
class Singleton4{
    private Singleton4(){}
    private static class SingletonInstance{
        private static final Singleton4 INSTANCE = new Singleton4();
    }
    public static Singleton4 Singleton4(){
        return SingletonInstance.INSTANCE;
    }
}
enum Singleton5{INSTANCE;}