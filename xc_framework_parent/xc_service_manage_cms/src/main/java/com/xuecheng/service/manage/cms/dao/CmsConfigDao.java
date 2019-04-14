package com.xuecheng.service.manage.cms.dao;


import com.xuecheng.framework.domain.cms.CmsConfig;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CmsConfigDao extends MongoRepository<CmsConfig,String> {
}
