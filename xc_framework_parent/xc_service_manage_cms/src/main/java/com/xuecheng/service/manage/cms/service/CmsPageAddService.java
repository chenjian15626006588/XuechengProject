package com.xuecheng.service.manage.cms.service;

import com.xuecheng.framework.common.model.response.CommonCode;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.service.manage.cms.dao.CmsPageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CmsPageAddService {
    @Autowired
    private CmsPageDao cmsPageDao;

    public CmsPageResult add(CmsPage cmsPage){
        //判断数据库中是否已经存在当前页面
        CmsPage cmsPage1 = cmsPageDao.findByPageNameAndSiteIdAndPageWebPath(cmsPage.getPageName(),cmsPage.getSiteId(),cmsPage.getPageWebPath());

        if (cmsPage1 == null){
            cmsPage.setPageId(null);//添加页面主键由spring data 自动生成
            cmsPageDao.save(cmsPage);
            return new CmsPageResult(CommonCode.SUCCESS,cmsPage);
        }

        return new CmsPageResult(CommonCode.FAIL,cmsPage);
    }

}
