package com.xuecheng.service.ucenter.auth.service;

import com.xuecheng.framework.domain.ucenter.ext.AuthToken;
import io.micrometer.core.instrument.util.TimeUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class MyAuthTokenService {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Resource
    private RestTemplate restTemplate;

    PasswordEncoder bCryptPasswordEncoder;

    //获取httpbasic的串
    private String getHttpBasic(String clientId,String clientSecret){
        String string = clientId+":"+clientSecret;
        //将串进行base64编码
        byte[] encode = Base64Utils.encode(string.getBytes());
        return "Basic "+new String(encode);
    }

    /**
     * 保存令牌到redis中
     * @param access_token 将access_token作为redis中的key
     * @param message
     * @param time 过期时间
     * @return
     */
    public boolean saveToken(String access_token,String message,long time){
        String key = "user_token:" + access_token;
        redisTemplate.boundValueOps(key).set(message, time,TimeUnit.SECONDS);
        return redisTemplate.getExpire(key,TimeUnit.SECONDS) > 0;
    }

    /**
     * 申请jwt令牌
     * @param username
     * @param password
     * @param clientId
     * @param clientSecret
     * @return
     */
    public AuthToken applyToken(String username, String password, String clientId, String clientSecret){
        //定义url
        String url = "http://localhost:40400/oauth/token";
        //定义grant-_type,username,password
        LinkedMultiValueMap body = new LinkedMultiValueMap();
        body.add("grant_type","password");
        body.add("username",username);
        body.add("password",password);
        //定义Header
        LinkedMultiValueMap header = new LinkedMultiValueMap();
        String httpBasic = getHttpBasic(clientId,clientSecret);
        header.add("Authorization",httpBasic);

        //使用Post方式请求获取jwt令牌
        HttpEntity<MultiValueMap<String,String>> httpEntity = new HttpEntity<>(body,header);
        ResponseEntity<Map> exchang = restTemplate.exchange(url, HttpMethod.POST,httpEntity, Map.class);

        //将令牌的信息封装成AuthToken对象
        Map bodyMap = exchang.getBody();
        AuthToken authToken = new AuthToken();
        authToken.setAccess_token((String) bodyMap.get("jti"));
        authToken.setRefresh_token((String) bodyMap.get("refresh_token"));
        authToken.setJwt_token((String) bodyMap.get("access_token"));

        return authToken;
    }
}
