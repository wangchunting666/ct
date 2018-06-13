package com.ct.mybatis.plus.service.impl;

import com.ct.mybatis.plus.dao.AuthMapper;
import com.ct.mybatis.plus.model.Auth;
import com.ct.mybatis.plus.service.IAuthService;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/** 
* AuthServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 11, 2018</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AuthServiceImplTest {
    @Autowired
    private IAuthService iAuthService;
    @Before
    public void before() throws Exception {}
    @After
    public void after() throws Exception {}
    @Test
    public void selectAll(){
        List<Auth> list = iAuthService.selectByMap(new HashMap<>());
        System.out.println(list);
    }

} 
