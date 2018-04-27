package com.ct.arithmetic;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

/** 
* SortExample Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 27, 2018</pre> 
* @version 1.0 
*/ 
public class SortExampleTest { 

    @Before
    public void before() throws Exception {}

    @After
    public void after() throws Exception {}

    /**
    * Method: less(Comparable v, Comparable w)
    */
    @Test
    public void testLess() throws Exception {
        //boolean flag = SortExample.less();
        String[] s = {"s","A","o","P","p","v","b","n","n","M","r","t"};
//        Selection.sort(s);
//        Selection.show(s);
//        Insertion.sort(s);
        Insertion.sort2(s);
        Insertion.show(s);
    }

} 
