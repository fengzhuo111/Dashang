package com.fengzhuo.dashang.service;

import com.alibaba.fastjson.JSON;
import com.fengzhuo.dashang.dao.DsDraftDao;
import com.fengzhuo.dashang.dao.DsInboxDao;
import com.fengzhuo.dashang.dao.DsSentDao;
import com.fengzhuo.dashang.dao.DsUserDao;
import com.fengzhuo.dashang.pojo.entity.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service(value = "receiveservice")
public class ReceiveService {
    @Resource
    DsDraftDao draftDao;
    @Resource
    DsInboxDao inboxDao;
    @Resource
    DsUserDao userDao;
    @Resource
    DsSentDao sentDao;


    public int countUnReadNum(String userName) {
        int num = 0;
        num = inboxDao.selectUnReadNum(userName);
        return num;
    }

    public int countDraftNum(String userName){
        int num = 0;
        num = draftDao.selectDraftNum(userName);

        return num;
    }

    public int countMailNum(String userName) {
        int num = 0;
        num = inboxDao.selectMailNum(userName);
        return num;
    }

    public int countSentNum(String userName) {
        int num = 0;
        num = sentDao.selectSentNum(userName);
        return num;
    }
//    public String selectInbox(String userName){
//        int userId = userDao.selectUserID(userName);
//        List<DsInbox> inboxes = inboxDao.selectInbox(userId);
//        String result = JSON.toJSONString(inboxes);
//        System.out.println(result);
//        return result;
//    }


    public PageResult<DsInbox> queryInbox(String userName, Integer page, Integer size) {
        int userId = userDao.selectUserID(userName);
        // 添加分页条件
        PageHelper.startPage(page,size);

        Page<DsInbox> inboxes = inboxDao.selectInbox(userId);
        PageInfo<DsInbox> pageInfo = new PageInfo<>(inboxes);
        return new PageResult<>(pageInfo.getTotal(),pageInfo.getList());
    }

    public PageResult<DsDraft> queryDraft(String userName, Integer page, Integer size) {
        int userId = userDao.selectUserID(userName);
        System.out.println(userId);
        // 添加分页条件

        PageHelper.startPage(page,size);

        Page<DsDraft> drafts = draftDao.selectDraft(userId);
        PageInfo<DsDraft> pageInfo = new PageInfo<>(drafts);
        return new PageResult<>(pageInfo.getTotal(),pageInfo.getList());
    }

    public PageResult<DsSent> querySent(String userName, Integer page, Integer size) {
        int userId = userDao.selectUserID(userName);
        System.out.println(userId);
        // 添加分页条件

        PageHelper.startPage(page,size);

        Page<DsSent> drafts = sentDao.selectSent(userId);
        PageInfo<DsSent> pageInfo = new PageInfo<>(drafts);
        return new PageResult<>(pageInfo.getTotal(),pageInfo.getList());
    }


}
