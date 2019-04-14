package com.xuecheng.service.ucenter.auth.test.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BCrypt64 {
    @Test
    public void BPassword(){
        System.out.println(new BCryptPasswordEncoder().encode("XcWebApp"));
    }
}
