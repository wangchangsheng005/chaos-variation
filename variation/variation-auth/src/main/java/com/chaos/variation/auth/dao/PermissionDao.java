package com.chaos.variation.auth.dao;

import com.chaos.variation.common.entity.Permission;

import java.util.List;

/**
 * 〈权限Dao〉
 * @Description:TODO
 * @Author:Mr.Wang
 * @Date:2019/9/04/0027 15:34
 * @Version 1.0
 **/
public interface PermissionDao {

    /**
     * 根据角色id查找权限列表
     * @param roleId 角色id
     * @return 权限列表
     */
    List<Permission> findByRoleId(Integer roleId);
}
