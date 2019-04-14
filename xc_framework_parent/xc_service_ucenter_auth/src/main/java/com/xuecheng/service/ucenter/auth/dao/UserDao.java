package com.xuecheng.service.ucenter.auth.dao;

import com.xuecheng.framework.domain.ucenter.XcUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface UserDao extends JpaRepository<XcUser,String> {
    XcUser findByUsernameIs(String username);
}
