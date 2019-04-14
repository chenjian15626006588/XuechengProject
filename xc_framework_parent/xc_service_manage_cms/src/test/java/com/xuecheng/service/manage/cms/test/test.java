package com.xuecheng.service.manage.cms.test;

import com.xuecheng.service.manage.cms.dao.CmsPageDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class test {

    @Autowired
    CmsPageDao cmsPageDao;

    @Test
    public void daoTest(){

    }
}
