package com.fengzhuo.dashang.dao;

import com.fengzhuo.dashang.pojo.entity.DsUser;

public interface DsUserDao {
    int deleteByPrimaryKey(Integer userId);

    int insert(DsUser record);

    int insertSelective(DsUser record);

    DsUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(DsUser record);

    int updateByPrimaryKey(DsUser record);

    DsUser selectUserByRealName(String name);

    String selectPasswordByName(String name);

    int selectUserID(String name);

    int selectUserIdByEmail(String email);

    String selectUserNameByEmail(String email);
}