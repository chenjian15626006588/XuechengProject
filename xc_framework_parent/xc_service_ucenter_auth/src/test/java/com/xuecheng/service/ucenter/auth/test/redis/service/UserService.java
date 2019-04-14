package com.xuecheng.service.ucenter.auth.test.redis.service;

import com.xuecheng.service.ucenter.auth.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Table;

@SpringBootTest
@RunWith(SpringRunner.class)
@EnableJpaRepositories(basePackages = "com.xuecheng.service.ucenter.auth.dao")
@EntityScan("com.xuecheng.framework.domain.ucenter")
public class UserService {
    @Autowired
    private UserDao userDao;

    @Test
    public void find(){
        System.out.println(userDao.findByUsernameIs("super"));
    }
}
