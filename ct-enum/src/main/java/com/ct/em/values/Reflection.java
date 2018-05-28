package com.ct.em.values;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Herdsric-M-003 on 2018/5/25.
 */
class Reflection {
    public static Set<String> analyze(Class<?> enumClass){
        System.out.println("----- Analyzing "+enumClass+"------");
        System.out.println("Interfaces");
        for(Type t:enumClass.getGenericInterfaces()){
            System.out.println(t);
        }
        System.out.println("Base:"+enumClass.getSuperclass());
        System.out.println("Methods:");
        Set<String> methods = new TreeSet<>();
        for(Method m:enumClass.getMethods()){
            methods.add(m.getName());
        }
        return methods;
    }
}
