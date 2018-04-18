package com.ct.chapter;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

/** 
* BasicFileOutPut Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 18, 2018</pre> 
* @version 1.0 
*/ 
public class BasicFileOutPutTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: fileOutPut(String filename) 
* 
*/ 
@Test
public void testFileOutPut() throws Exception {
    String filename = "D:\\workspace\\github\\ct\\ct-chapter18\\src\\main\\java\\com\\ct\\chapter\\BufferInputFile.java";
    BasicFileOutPut.fileOutPut(filename);
} 


} 
