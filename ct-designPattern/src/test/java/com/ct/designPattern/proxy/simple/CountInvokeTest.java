package com.ct.designPattern.proxy.simple;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

/** 
* CountInvoke Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 3, 2018</pre> 
* @version 1.0 
*/ 
public class CountInvokeTest { 

    @Before
    public void before() throws Exception {}

    @After
    public void after() throws Exception {}

    /**
    *
    * Method: invoke(Object proxy, Method method, Object[] args)
    *
    */
    @Test
    public void testInvoke() throws Exception {
        IRegist fromEmail = new FromEmail();
        IRegist fromPost = new FromPost();

        CountInvoke countInvokeEmail = new CountInvoke(fromEmail);
        CountInvoke countInvokePost  = new CountInvoke(fromPost);

        IRegist emailProxy = (IRegist)GenericProxy.createProxy(fromEmail,countInvokeEmail);
        IRegist postProxy = (IRegist)GenericProxy.createProxy(fromPost,countInvokePost);

        emailProxy.regist("eamil");
        postProxy.regist("post");

        System.out.println(countInvokeEmail.getCount());
        System.out.println(countInvokePost.getCount());
    }

    /**
    *
    * Method: getCount()
    *
    */
    @Test
    public void testGetCount() throws Exception {

    }


} 
