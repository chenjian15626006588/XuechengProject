package com.xuecheng.service.ucenter.auth.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.xuecheng.framework.domain.ucenter.ext.AuthToken;
import com.xuecheng.service.ucenter.auth.service.LoginService;
import com.xuecheng.service.ucenter.auth.service.MyAuthTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class authController {

    @Autowired
    LoginService loginService;

    @GetMapping("/userlogin")
    public String login() {

        loginService.login("super","123","XcWebApp","XcWebApp");

        return "hello word";
    }
}
