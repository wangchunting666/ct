package com.ct.mybatis.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Herdsric-M-003 on 2018/6/13.
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.ct.mybatis.boot.dao")
public class MybatisApplication {
    public static void main(String[] args){
        SpringApplication.run(MybatisApplication.class,args);
    }
}
