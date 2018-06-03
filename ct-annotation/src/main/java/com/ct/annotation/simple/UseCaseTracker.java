package com.ct.annotation.simple;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by dell on 2018/5/27.
 */
class UseCaseTracker {
    public static void trackUseCases(List<Integer> useCases,Class<?> cl){
        for (Method m:cl.getDeclaredMethods()){
            UseCase uc = m.getAnnotation(UseCase.class);
            if(uc != null){
                System.out.println("Found Use Case:"+uc.id()+" "+uc.description());
                useCases.remove(new Integer(uc.id()));
            }
        }
    }
}
