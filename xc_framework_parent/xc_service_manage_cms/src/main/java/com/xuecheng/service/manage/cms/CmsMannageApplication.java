package com.xuecheng.service.manage.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

//@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = "com.xuecheng.service.api")
@EntityScan("com.xuecheng.framework.domain.cms")
@ComponentScan(basePackages = "com.xuecheng.service.manage.cms")
public class CmsMannageApplication {

    public static void main(String[] args){
        SpringApplication.run(CmsMannageApplication.class,args);
    }

}
