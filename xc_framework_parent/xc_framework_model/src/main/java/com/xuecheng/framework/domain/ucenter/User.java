package com.xuecheng.framework.domain.ucenter;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "usertest")
public class User{
    @Id
    @Column
    private String id;
    @Column
    private String username;
    @Column
    private String password;
}
