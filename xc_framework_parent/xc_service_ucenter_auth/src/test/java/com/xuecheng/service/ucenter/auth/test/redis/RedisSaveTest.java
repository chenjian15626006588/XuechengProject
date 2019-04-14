package com.xuecheng.service.ucenter.auth.test.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisSaveTest {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void save(){
        redisTemplate.boundValueOps("token").set("helllll");
    }
}
