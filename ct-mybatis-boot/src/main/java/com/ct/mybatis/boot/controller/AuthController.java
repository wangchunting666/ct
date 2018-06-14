package com.ct.mybatis.boot.controller;


import com.ct.mybatis.boot.model.Auth;
import com.ct.mybatis.boot.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Yanghu
 * @since 2018-06-13
 */
@Controller
@RequestMapping("/boot/auth")
public class AuthController {
    @Autowired
    private IAuthService iAuthService;
    @ResponseBody
    @RequestMapping("/all")
    public Object all(){
        List<Auth> list = iAuthService.selectByMap(null);
        return list;
    }
}

