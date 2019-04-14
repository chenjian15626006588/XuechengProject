package com.xuecheng.service.manage.cms.service;

import com.xuecheng.framework.domain.cms.CmsConfig;
import com.xuecheng.service.manage.cms.dao.CmsConfigDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CmsConfigService {

    @Autowired
    private CmsConfigDao cmsConfigDao;

    public CmsConfig getModelById(String id){
        Optional<CmsConfig> optional = cmsConfigDao.findById(id);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }

}
