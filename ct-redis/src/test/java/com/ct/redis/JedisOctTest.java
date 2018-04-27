package com.ct.redis;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

/** 
* JedisOct Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 24, 2018</pre> 
* @version 1.0 
*/ 
public class JedisOctTest { 

    @Before
    public void before() throws Exception {}

    @After
    public void after() throws Exception {}

    /**
    *
    * Method: connnectRedis()
    *
    */
    @Test
    public void testConnnectRedis() throws Exception {
        JedisOct.connnectRedisSet();
        //JedisOct.connnectRedisGet();
    }


} 
