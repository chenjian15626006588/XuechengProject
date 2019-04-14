package com.xuecheng.service.manage.cms.Controller;

import com.xuecheng.framework.common.model.response.CommonCode;
import com.xuecheng.framework.common.model.response.QueryResponseResult;
import com.xuecheng.framework.common.model.response.QueryResult;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.service.api.cms.CmsPageControllerApi;
import com.xuecheng.service.manage.cms.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping("/cms/page")
public class CmsPageController implements CmsPageControllerApi {
    @Autowired
    private CmsPageService cmsPageService;
    @Autowired
    private CmsSiteService cmsSiteService;
    @Autowired
    private CmsPageAddService cmsPageAddService;
    @Autowired
    private CmsTemplateService cmsTemplateService;
    @Autowired
    private CmsPageEditService cmsPageEditService;

    /**
     * 分页查询
     * @param page
     * @param size
     * @param queryPageRequest
     * @return
     */
    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size") int size, QueryPageRequest queryPageRequest) {

        return cmsPageService.findList(page,size,queryPageRequest);
    }

    @GetMapping("/list/siteidlist")
    public QueryResponseResult findSiteIdList(){
        return cmsSiteService.findSiteList();
    }

    @Override
    @GetMapping("/list/cmsTemplateList")
    public QueryResponseResult findCmsTemplateList() {
        return cmsTemplateService.findCmsTemplateList();
    }


    /**
     * 新增页面
     * @param cmsPage
     * @return
     */
    @Override
    @PostMapping("/add")
    public CmsPageResult add(@RequestBody CmsPage cmsPage) {
        return cmsPageAddService.add(cmsPage);
    }

    @Override
    @GetMapping("/get/{id}")
    public CmsPage findbyId(@PathVariable("id") String id) {
        return cmsPageEditService.getById(id);
    }

    @Override
    @PutMapping("/edit/{id}")
    public CmsPageResult edit(@PathVariable("id") String id,@RequestBody CmsPage cmsPage) {
        return cmsPageEditService.edit(id,cmsPage);
    }
}
