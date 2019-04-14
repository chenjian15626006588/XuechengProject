package com.xuecheng.service.api.cms;

import com.xuecheng.framework.domain.cms.CmsTemplate;
import com.xuecheng.framework.domain.cms.response.CmsTemplateResult;
import io.swagger.annotations.Api;

@Api(value="cms页面模板管理接口",description = "提供页面模板的增、删、改、查")
public interface CmsTemplateApi {
    //增加
    public CmsTemplateResult add(CmsTemplate cmsTemplate);

    //删


    //改

    //查询

}
