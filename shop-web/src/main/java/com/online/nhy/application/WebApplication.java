package com.online.nhy.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableConfigurationProperties
@MapperScan(value = {"com.online.nhy.mapper"},properties = {
        "mappers=tk.mybatis.mapper.common.Mapper",
        "notEmpty=true"
})
@ComponentScan(basePackages = { "com.online.nhy" })
public class WebApplication {

    public static void main(String[] args){
        SpringApplication.run(WebApplication.class,args);
    }
}
