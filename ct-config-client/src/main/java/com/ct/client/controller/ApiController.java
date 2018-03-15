package com.ct.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Herdsric-M-003 on 2018/3/14.
 */
@RestController
public class ApiController {
    @Autowired
    private Environment env;

    @Value("${spring.redis.host}")
    private String spring_redis_host;

    @RequestMapping("/api")
    public String api(){
        System.out.println(env.getProperty("password"));
        return spring_redis_host;
    }
}
