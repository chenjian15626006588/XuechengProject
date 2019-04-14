package com.xuecheng.service.ucenter.auth.test.redis;

import com.xuecheng.framework.domain.ucenter.User;
import com.xuecheng.service.ucenter.auth.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.xuecheng.service.ucenter.auth.dao")
@EntityScan("com.xuecheng.framework.domain.ucenter")
@ComponentScan("com.xuecheng.service.ucenter.auth.test.redis.service")
public class SpringDataTest {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataTest.class,args);
    }
}
