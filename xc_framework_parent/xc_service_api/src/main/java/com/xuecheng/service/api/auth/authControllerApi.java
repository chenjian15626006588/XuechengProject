package com.xuecheng.service.api.auth;

import com.xuecheng.framework.common.model.response.ResponseResult;
import com.xuecheng.framework.domain.ucenter.request.LoginRequest;
import com.xuecheng.framework.domain.ucenter.response.LoginResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="用户认证",description = "用户认证接口，提供登录和退出")
public interface authControllerApi {
    @ApiOperation("用户登录接口")
    public LoginResult login(LoginRequest loginRequest);

    @ApiOperation("用户退出")
    public ResponseResult Logout();
}
