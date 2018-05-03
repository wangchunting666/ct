package com.ct.designPattern.bridging;

import com.ct.designPattern.bridging.simle.MyList;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.ArrayList;
import java.util.List;

/** 
* MyList Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 2, 2018</pre> 
* @version 1.0 
*/ 
public class MyListTest { 
    private List<String> sList;
    @Before
    public void before() throws Exception {
        sList = new ArrayList<>();
        sList.add("hello");
        sList.add("ello");
        sList.add("llo");
        sList.add("lo");
        sList.add("o");
        sList.add("t");
    }

    @After
    public void after() throws Exception {}

    /**
    *
    * Method: sort()
    *
    */
    @Test
    public void testSort() throws Exception {
        MyList<String> list = new MyList<>(sList);
        list.sort();
        list.descriptionList();
        list.descriptionArray();
        list.fill();
        list.descriptionList();
        list.descriptionArray();
    }


} 
