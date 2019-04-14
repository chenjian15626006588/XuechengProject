package com.xuecheng.service.api.cms;

import com.xuecheng.framework.common.model.response.QueryResponseResult;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="cms页面管理接口",description = "cms页面管理接口，提供页面的增、删、改、查")
public interface CmsPageControllerApi {
    @ApiOperation("分页查询接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value = "页码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录数",required=true,paramType="path",dataType="int")
                    })
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest);

    @ApiOperation("CmsSite查询接口")
    public QueryResponseResult findSiteIdList();

    @ApiOperation("CmsTemplate查询接口")
    public QueryResponseResult findCmsTemplateList();

    @ApiOperation("新增页面")
    public CmsPageResult add(CmsPage cmsPage);

    @ApiOperation("根据页面id查找页面")
    public CmsPage findbyId(String id);

    @ApiOperation("修改页面信息")
    public CmsPageResult edit(String id,CmsPage cmsPage);

}
