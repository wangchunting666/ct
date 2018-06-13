package com.ct.mybatis.plus.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.ct.mybatis.plus.service.ITestService;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/** 
* TestServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 11, 2018</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestServiceImplTest {
    @Autowired
    private ITestService iTestService;
    private com.ct.mybatis.plus.model.Test test1 = new com.ct.mybatis.plus.model.Test();
    private com.ct.mybatis.plus.model.Test test2 = new com.ct.mybatis.plus.model.Test();
    private boolean flag = false;
    private DateTimeFormatter dtf;
    @Before
    public void before() throws Exception {
        LocalDateTime ldt=LocalDateTime.now();
        dtf= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        test1.setName("测试1");
        test1.setContent("测试1的内容");
        test1.setRemark("测试1的备注");
        test1.setCdate(ldt.format(dtf));
        test2.setName("测试2");
        test2.setContent("测试2的内容");
        test2.setRemark("测试2的备注");
        test2.setCdate(ldt.format(dtf));
    }
    @After
    public void after() throws Exception {}
    @Test
    public void insert(){
        List<com.ct.mybatis.plus.model.Test> list = new ArrayList<>();
        list.add(test1);
        list.add(test2);
        //flag = iTestService.insert(test1);
        //flag = iTestService.insertAllColumn(test1);
        //flag = iTestService.insertBatch(list);
        //flag = iTestService.insertBatch(list,1);
        //flag = iTestService.insertOrUpdate(test2);
        //flag = iTestService.insertOrUpdateAllColumn(test2);
        //flag = iTestService.insertOrUpdateAllColumnBatch(list);
        //flag = iTestService.insertOrUpdateAllColumnBatch(list,1);
        //flag = iTestService.insertOrUpdateBatch(list);
        //flag = iTestService.insertOrUpdateBatch(list,1);
    }
    @Test
    public void update(){
        Wrapper<com.ct.mybatis.plus.model.Test> wrapper = new EntityWrapper<>();
        wrapper.where("t_id = {0}","2");
//        System.out.println(wrapper.getSqlSegment());
//        flag = iTestService.update(test2,wrapper);

        List<com.ct.mybatis.plus.model.Test> list = new ArrayList<>();
        list.add(test1);
        list.add(test2);
        //flag = iTestService.updateAllColumnBatchById(list);
        //flag = iTestService.updateAllColumnBatchById(list,1);
        //flag = iTestService.updateForSet();未测试
        System.out.println(flag);
    }

    @Test
    public void delete(){
        Wrapper<com.ct.mybatis.plus.model.Test> wrapper = new EntityWrapper<>();
        wrapper.where("t_id = {0}","2");
        //flag = iTestService.delete(wrapper);
        //flag = iTestService.deleteBatchIds(new ArrayList<>().add(new ))

        System.out.println(flag);
    }

    @Test
    public void select(){

    }
} 
