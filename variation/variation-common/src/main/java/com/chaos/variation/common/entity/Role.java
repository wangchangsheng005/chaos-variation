package com.chaos.variation.common.entity;

import lombok.Data;

import java.util.Date;
import java.util.Set;

/**
 * 〈角色实体〉
 *
 * @Description:TODO
 * @Author:Mr.Wang
 * @Date:2019/9/04/0027 15:34
 * @Version 1.0
 **/
@Data
public class Role {

    private int id;
    private String roleName;
    private short valid;
    private Date createTime;
    private Date updateTime;
    private Set<Permission> permissions;
}
