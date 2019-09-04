package com.chaos.variation.auth.dao;


import com.chaos.variation.common.entity.Role;

import java.util.List;

/**
 * 〈角色Dao〉
 * @Description:TODO
 * @Author:Mr.Wang
 * @Date:2019/9/04/0027 15:34
 * @Version 1.0
 **/
public interface RoleDao {

    /**
     * 根据用户id查找角色列表
     * @param memberId 用户id
     * @return 角色列表
     */
    List<Role> findByMemberId(Integer memberId);
}
