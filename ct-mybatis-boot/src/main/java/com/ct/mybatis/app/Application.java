package com.ct.mybatis.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Herdsric-M-003 on 2018/7/12.
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.ct.mybatis.dao")
@ComponentScan(basePackages = {"com.ct.mybatis.web","com.ct.mybatis.service","com.ct.mybatis.app"})
public class Application {
    public static void main(String[] args){SpringApplication.run(Application.class,args);}
}
