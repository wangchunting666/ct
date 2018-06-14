package com.ct.mybatis.boot.controller;


import com.ct.mybatis.boot.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Yanghu
 * @since 2018-06-13
 */
@Controller
@RequestMapping("/boot/test")
public class TestController {
    @Autowired
    private ITestService iTestService;
    @ResponseBody
    @RequestMapping("/getAllData")
    public Object getAllData(){
        return iTestService.selectByMap(null);
    }
}

