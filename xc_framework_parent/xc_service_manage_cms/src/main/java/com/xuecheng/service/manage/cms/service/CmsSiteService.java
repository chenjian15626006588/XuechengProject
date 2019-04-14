package com.xuecheng.service.manage.cms.service;

import com.xuecheng.framework.common.model.response.CommonCode;
import com.xuecheng.framework.common.model.response.QueryResponseResult;
import com.xuecheng.framework.common.model.response.QueryResult;
import com.xuecheng.framework.domain.cms.CmsSite;
import com.xuecheng.service.manage.cms.dao.CmsSiteDao;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmsSiteService {

    @Autowired
    private CmsSiteDao cmsSiteDao;

    public QueryResponseResult findSiteList(){

        List<CmsSite> list = cmsSiteDao.findAll();
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);

        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }
}
