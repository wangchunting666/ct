package com.ct.annotation.simple;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by dell on 2018/5/27.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface UseCase {
    public int id();
    public String description() default "no description";
}
