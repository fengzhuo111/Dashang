package com.fengzhuo.dashang.dao;

import com.fengzhuo.dashang.pojo.entity.DsSent;
import com.github.pagehelper.Page;

public interface DsSentDao {
    int deleteByPrimaryKey(Integer sentId);

    int insert(DsSent record);

    int insertSelective(DsSent record);

    DsSent selectByPrimaryKey(Integer sentId);

    int updateByPrimaryKeySelective(DsSent record);

    int updateByPrimaryKey(DsSent record);

    Page<DsSent> selectSent(int userId);

    int selectSentNum(String name);
}