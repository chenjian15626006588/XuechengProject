package com.xuecheng.service.ucenter.auth.service;

import com.alibaba.fastjson.JSON;
import com.xuecheng.framework.domain.ucenter.ext.AuthToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    MyAuthTokenService myAuthTokenService;

    public void login(String username,String password,String clientId,String clientSecret){
        AuthToken authToken = myAuthTokenService.applyToken(username,password,clientId,clientSecret);
        String access_token = authToken.getAccess_token();
        String message = JSON.toJSONString(authToken);
        myAuthTokenService.saveToken(access_token,message,1200);
    }
}
