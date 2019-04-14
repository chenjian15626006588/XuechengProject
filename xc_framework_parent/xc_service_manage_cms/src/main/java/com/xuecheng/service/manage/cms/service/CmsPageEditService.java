package com.xuecheng.service.manage.cms.service;

import com.xuecheng.framework.common.model.response.CommonCode;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.service.manage.cms.dao.CmsPageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CmsPageEditService {
    @Autowired
    private CmsPageDao cmsPageDao;

    //根据id查找cmsPage
    public CmsPage getById(String id){

        Optional<CmsPage> optional = cmsPageDao.findById(id);
        //如果不为空
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    //修改页面
    public CmsPageResult edit(String id,CmsPage cmsPage){

        CmsPage one = this.getById(id);
        if (one != null){
            //更新模板id
            one.setTemplateId(cmsPage.getTemplateId());
            //更新所属站点
            one.setSiteId(cmsPage.getSiteId());
            //更新页面别名
            one.setPageAliase(cmsPage.getPageAliase());
            //更新页面名称
            one.setPageName(cmsPage.getPageName());
            //更新访问路径
            one.setPageWebPath(cmsPage.getPageWebPath());
            //更新物理路径
            one.setPagePhysicalPath(cmsPage.getPagePhysicalPath());
            if (one != null){
                CmsPage save = cmsPageDao.save(one);
                return new CmsPageResult(CommonCode.SUCCESS,save);
            }
        }

        return new CmsPageResult(CommonCode.FAIL,null);
    }
}
