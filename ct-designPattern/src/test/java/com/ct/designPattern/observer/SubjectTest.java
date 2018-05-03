package com.ct.designPattern.observer;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;

import java.util.Observer;

/** 
* Subject Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 1, 2018</pre> 
* @version 1.0 
*/ 
public class SubjectTest { 

    @Before
    public void before() throws Exception {}

    @After
    public void after() throws Exception {}

    @Test
    public void testRegister() throws Exception {
        SubjectPush subject = new SubjectPush();
        subject.setData("hello");
        IObserver observer1 = new ObserverRealize1();
        subject.register(observer1);
        subject.notifyAllObserver();
        subject.unregister(observer1);
        subject.notifyAllObserver();

//        IObserver<SubjectPush> observer2 = new ObserverRealize2();
//        subject.register(observer2);
//        subject.notifyAllObserver();
    }
    @Test
    public void testPull() throws Exception {
        SubjectPull subject = new SubjectPull();
        subject.setData("hello");
        IObserver observer1 = new ObserverRealize2();
        subject.register(observer1);
        subject.notifyAllObserver();
        subject.unregister(observer1);
        subject.notifyAllObserver();

    }
    @Test
    public void testReflect() throws Exception{
        SubjectXml subjectXml = new SubjectXml();
        subjectXml.register("/observerXml.xml");
        subjectXml.setData("observerXml.xml");
        subjectXml.notifyAllObserver();
    }
    @Test
    public void testSubjectJdk() throws Exception{
        SubjectJdk subjectJdk = new SubjectJdk();
        Observer observer = new ObserverRealizeJdk();
        subjectJdk.addObserver(observer);
        subjectJdk.setData("JDK Subject");
    }

} 
