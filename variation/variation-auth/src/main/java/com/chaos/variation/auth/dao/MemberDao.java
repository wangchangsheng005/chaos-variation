package com.chaos.variation.auth.dao;


import com.chaos.variation.common.entity.Member;

/**
 * 〈用户Dao〉
 *
 * @author Mr. Wang
 * @create 2018/12/13
 * @since 1.0.0
 */
public interface MemberDao {

    /**
     * 根据会员名查找会员
     * @param memberName 会员名
     * @return 会员
     */
    Member findByMemberName(String memberName);
}
