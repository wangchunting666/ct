package com.ct.declare;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.List;
import java.util.Map;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.After;
import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;

/** 
* Declare Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 17, 2018</pre> 
* @version 1.0 
*/ 
public class DeclareTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

@Test
public void excelReadToMapListTest() throws Exception{
    ExcelReader reader = ExcelUtil.getReader(ResourceUtil.getStream("SKMBT-55218040814570.xlsx"));
    List<List<Object>> read = reader.read();
    System.out.println(read.toString());
}

} 
