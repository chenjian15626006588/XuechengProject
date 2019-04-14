package com.xuecheng.service.manage.cms.service;

import com.xuecheng.framework.common.model.response.CommonCode;
import com.xuecheng.framework.common.model.response.QueryResponseResult;
import com.xuecheng.framework.common.model.response.QueryResult;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.service.manage.cms.dao.CmsPageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;


@Service
public class CmsPageService {
    @Autowired
    private CmsPageDao cmsPageDao;

    /**
     * 分页查询
     * @param page
     * @param size
     * @param queryPageRequest
     * @return
     */
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest){

        CmsPage cmsPage = new CmsPage();
        if (!(queryPageRequest.getSiteId().isEmpty())){
            cmsPage.setSiteId(queryPageRequest.getSiteId());
        }
        if (!(queryPageRequest.getPageAliase().isEmpty())){
            cmsPage.setPageAliase(queryPageRequest.getPageAliase());
        }

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("pageAliase",ExampleMatcher.GenericPropertyMatchers.contains());
        //定义条件匹配器
        Example<CmsPage> example = Example.of(cmsPage,matcher);

        Pageable pageable = PageRequest.of(page-1, size);
        Page<CmsPage> all = cmsPageDao.findAll(example,pageable);

        QueryResult queryResult = new QueryResult();
        queryResult.setList(all.getContent());
        queryResult.setTotal(all.getTotalElements());

        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }

}
