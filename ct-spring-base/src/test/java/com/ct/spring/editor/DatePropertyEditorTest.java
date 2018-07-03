package com.ct.spring.editor;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
* DatePropertyEditor Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 1, 2018</pre> 
* @version 1.0 
*/ 
public class DatePropertyEditorTest { 

    @Before
    public void before() throws Exception { }

    @After
    public void after() throws Exception { }

    /**
    *
    * Method: setFormat(String format)
    *
    */
    @Test
    public void testSetFormat() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-dao.xml");
        User user = context.getBean("user",User.class);
        System.out.println(user);
    }

    /**
    *
    * Method: setAsText(String text)
    *
    */
    @Test
    public void testSetAsText() throws Exception {
    //TODO: Test goes here...
    }


} 
