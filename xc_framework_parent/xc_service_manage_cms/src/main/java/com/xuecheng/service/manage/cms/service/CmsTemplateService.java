package com.xuecheng.service.manage.cms.service;

import com.xuecheng.framework.common.model.response.CommonCode;
import com.xuecheng.framework.common.model.response.QueryResponseResult;
import com.xuecheng.framework.common.model.response.QueryResult;
import com.xuecheng.framework.domain.cms.CmsTemplate;
import com.xuecheng.service.manage.cms.dao.CmsTemplateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmsTemplateService {

    @Autowired
    private CmsTemplateDao cmsTemplateDao;

    public QueryResponseResult findCmsTemplateList(){

        List<CmsTemplate> list = cmsTemplateDao.findAll();

        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);

        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }

}
