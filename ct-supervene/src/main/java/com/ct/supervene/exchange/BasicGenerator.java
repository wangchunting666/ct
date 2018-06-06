package com.ct.supervene.exchange;

/**
 * Created by Herdsric-M-003 on 2018/6/4.
 */
public class BasicGenerator<T> implements Generator<T>{
    private Class<T> cls;
    public BasicGenerator(Class<T> cls){
        this.cls = cls;
    }
    @Override
    public T next() {
        T tObject;
        try {
            tObject = cls.newInstance();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return tObject;
    }
    public static <T> Generator<T> create(Class<T> cls){
        return new BasicGenerator<T>(cls);
    }
}
