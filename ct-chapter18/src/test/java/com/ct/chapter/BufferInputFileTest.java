package com.ct.chapter;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;

/** 
* BufferInputFile Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 18, 2018</pre> 
* @version 1.0 
*/ 
public class BufferInputFileTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: read(String filename) 
* 
*/ 
@Test
public void testRead() throws Exception { 
    String filename = "D:\\workspace\\github\\ct\\ct-chapter18\\src\\main\\java\\com\\ct\\chapter\\BufferInputFile.java";
//    String result = BufferInputFile.read(filename);
//    BufferInputFile.memoryInput(filename);
    BufferInputFile.formatInput(filename);
}

} 
