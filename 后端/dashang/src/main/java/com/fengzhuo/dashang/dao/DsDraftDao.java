package com.fengzhuo.dashang.dao;

import com.fengzhuo.dashang.pojo.entity.DsDraft;
import com.github.pagehelper.Page;

public interface DsDraftDao {
    int deleteByPrimaryKey(Integer draftId);

    int insert(DsDraft record);

    int insertSelective(DsDraft record);

    DsDraft selectByPrimaryKey(Integer draftId);

    int updateByPrimaryKeySelective(DsDraft record);

    int updateByPrimaryKey(DsDraft record);

    int selectDraftNum(String name);

    Page<DsDraft> selectDraft(Integer userId);
}