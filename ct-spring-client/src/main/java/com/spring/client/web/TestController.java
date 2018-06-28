package com.spring.client.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Herdsric-M-003 on 2018/6/28.
 */
@RefreshScope
@RestController
public class TestController {
    @Value("${password}")
    private String password;

    @Autowired
    private Environment env;

    @RequestMapping("/password")
    public Object password(){return password;}

    @RequestMapping("/password1")
    public Object password1(){
        return env.getProperty("password");
    }
}
