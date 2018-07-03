package com.ct.spring.base;

import com.ct.spring.application.MyClassPathXmlApplicationContext;
import com.ct.spring.bean.Car;
import javafx.application.Application;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ClassRelativeResourceLoader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.expression.Expression;

/** 
* MyTestBean Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 18, 2018</pre> 
* @version 1.0 
*/ 
public class MyTestBeanTest { 

    @Before
    public void before() throws Exception {}

    @After
    public void after() throws Exception {}

    /**
    *
    * Method: getTestStr()
    *
    */
    @Test
    public void testGetTestStr() throws Exception {
        //TODO: Test goes here...
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext-dao.xml"));
        MyTestBean myTestBean = (MyTestBean) beanFactory.getBean("myTestBean");
        System.out.println(myTestBean.getTestStr());
    }

    /**
    *
    * Method: setTestStr(String testStr)
    *
    */
    @Test
    public void testSetTestStr() throws Exception {
        DefaultListableBeanFactory dlbf = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xbdr = new XmlBeanDefinitionReader(dlbf);
        xbdr.loadBeanDefinitions(new ClassPathResource("applicationContext-dao.xml"));
//        MyTestBean myTestBean = (MyTestBean) dlbf.getBean("myTestBean");
//        System.out.println(myTestBean.getTestStr());
        Car car = (Car)dlbf.getBean("&beanFactory");
        System.out.println(car);
    }

    /**
     *
     * Method: testApplicationContext(String testStr)
     *
     */
    @Test
    public void testApplicationContext() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext();
    }

    /**
     *
     * Method: testMyApplicationContext(String testStr)
     *
     */
    @Test
    public void testMyApplicationContext() throws Exception {
        ApplicationContext ac = new MyClassPathXmlApplicationContext("applicationContext-dao.xml");
    }


} 
