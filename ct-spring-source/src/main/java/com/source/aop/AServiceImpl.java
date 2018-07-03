package com.source.aop;

import org.springframework.aop.framework.AopContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Herdsric-M-003 on 2018/7/3.
 */
public class AServiceImpl implements AService{
    @Transactional(propagation= Propagation.REQUIRED)
    @Override
    public void a() {
        this.b();
        //expose-proxy = true 自调用事务执行
        //((AService)AopContext.currentProxy()).b();
    }
    @Transactional(propagation= Propagation.REQUIRES_NEW)
    @Override
    public void b() {

    }
}
