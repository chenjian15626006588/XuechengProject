package com.xuecheng.service.api.cms;

import com.xuecheng.framework.domain.cms.CmsConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="数据模型",description = "提供数据模型url等的接口")
public interface CmsConfigControllerApi {
    @ApiOperation("根据id获取数据模型接口")
    public CmsConfig getModel(String id);
}
