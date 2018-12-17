package com.bootmybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Created by mr on 2018/12/17.
 */
@SpringBootApplication
@MapperScan("com.bootmybatis.dao")
@EnableCaching
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
