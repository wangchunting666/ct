package com.ct.ehcache.service.impl;

import com.ct.ehcache.service.EhcacheService;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
* EhcacheServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 15, 2018</pre> 
* @version 1.0 
*/
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:applicationContext-ehcache.xml",})
@RunWith(SpringJUnit4ClassRunner.class)
public class EhcacheServiceImplTest {
    @Autowired
    private EhcacheService ehcacheService;
    @Before
    public void before() throws Exception {}

    @After
    public void after() throws Exception {}

    /**
    *
    * Method: getTimestamp(String param)
    *
    */
    @Test
    public void testGetTimestamp() throws Exception {
        System.out.println("第一次调用：" + ehcacheService.getTimestamp("param"));
        Thread.sleep(2000);
        System.out.println("2秒之后调用：" + ehcacheService.getTimestamp("param"));
        Thread.sleep(4000);
        System.out.println("再过4秒之后调用：" + ehcacheService.getTimestamp("param"));
    }

    /**
    *
    * Method: getDataFromDB(String key)
    *
    */
    @Test
    public void testGetDataFromDB() throws Exception {
        String key = "zhangsan";
        String value = ehcacheService.getDataFromDB(key); // 从数据库中获取数据...
        ehcacheService.getDataFromDB(key);  // 从缓存中获取数据，所以不执行该方法体
        ehcacheService.removeDataAtDB(key); // 从数据库中删除数据
        ehcacheService.getDataFromDB(key);  // 从数据库中获取数据...（缓存数据删除了，所以要重新获取，执行方法体）
    }

    /**
    *
    * Method: removeDataAtDB(String key)
    *
    */
    @Test
    public void testRemoveDataAtDB() throws Exception {
        String key = "mengdee";
        ehcacheService.refreshData(key);  // 模拟从数据库中加载数据
        String data = ehcacheService.getDataFromDB(key);
        System.out.println("data:" + data); // data:mengdee::103385

        ehcacheService.refreshData(key);  // 模拟从数据库中加载数据
        String data2 = ehcacheService.getDataFromDB(key);
        System.out.println("data2:" + data2);   // data2:mengdee::180538
    }

    /**
    *
    * Method: refreshData(String key)
    *
    */
    @Test
    public void testRefreshData() throws Exception {
    //TODO: Test goes here...
    }

    /**
    *
    * Method: findById(String userId)
    *
    */
    @Test
    public void testFindById() throws Exception {
    //TODO: Test goes here...
    }

    /**
    *
    * Method: isReserved(String userId)
    *
    */
    @Test
    public void testIsReserved() throws Exception {
    //TODO: Test goes here...
    }

    /**
    *
    * Method: removeUser(String userId)
    *
    */
    @Test
    public void testRemoveUser() throws Exception {
    //TODO: Test goes here...
    }

    /**
    *
    * Method: removeAllUser()
    *
    */
    @Test
    public void testRemoveAllUser() throws Exception {
    //TODO: Test goes here...
    }

} 
