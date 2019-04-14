package com.xuecheng.service.manage.cms.dao;

import com.xuecheng.framework.domain.cms.CmsTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CmsTemplateDao extends MongoRepository<CmsTemplate,String> {
}
