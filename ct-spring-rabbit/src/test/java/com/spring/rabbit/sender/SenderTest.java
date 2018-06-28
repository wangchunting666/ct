package com.spring.rabbit.sender;

import com.spring.rabbit.RabbitApplication;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

/** 
* Sender Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 27, 2018</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RabbitApplication.class)
public class SenderTest {
    @Autowired
    private Sender sender;
    @Before
    public void before() throws Exception {}

    @After
    public void after() throws Exception {}

    /**
    *
    * Method: send()
    *
    */
    @Test
    public void testSend() throws Exception {
        sender.send();
        TimeUnit.SECONDS.sleep(20);
    }


} 
