package com.source.aop;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import org.springframework.aop.config.AopNamespaceHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
* TestBean Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 3, 2018</pre> 
* @version 1.0 
*/ 
public class TestBeanTest { 
    private ApplicationContext context;
    @Before
    public void before() throws Exception {
        context = new ClassPathXmlApplicationContext("applicationContext-test.xml");
    }

    @After
    public void after() throws Exception {}

    /**
    *
    * Method: test()
    *
    */
    @Test
    public void testTest() throws Exception {
        TestBean testBean = context.getBean("test",TestBean.class);
        testBean.test();
//        AopNamespaceHandler;
    }


} 
