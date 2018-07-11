package com.source.aop;

import com.source.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

/** 
* TestBean Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 3, 2018</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:spring/applicationContext-dao.xml"
})
public class TestBeanTest {
    @Autowired private UserDao userDao;
    @Test
    public void testSelectAll() throws Exception{
        System.out.println(userDao.selectAll(null));
//        DataSourceTransactionManager
    }
} 
