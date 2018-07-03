package com.ct.spring.application;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dell on 2018/6/30.
 */
public class MyClassPathXmlApplicationContext extends ClassPathXmlApplicationContext{
    public MyClassPathXmlApplicationContext(String configLocation){
        super(configLocation);
    }
    @Override
    protected void initPropertySources() {
        System.out.println(getEnvironment().getDefaultProfiles());
        getEnvironment().setRequiredProperties("JAVA_HOME");
    }

    @Override
    protected void customizeBeanFactory(DefaultListableBeanFactory beanFactory) {
        setAllowBeanDefinitionOverriding(false);
        setAllowCircularReferences(false);
        super.customizeBeanFactory(beanFactory);
    }
}
