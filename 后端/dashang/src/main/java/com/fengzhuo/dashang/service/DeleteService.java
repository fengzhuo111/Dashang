package com.fengzhuo.dashang.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fengzhuo.dashang.dao.DsDraftDao;
import com.fengzhuo.dashang.dao.DsInboxDao;
import com.fengzhuo.dashang.dao.DsSentDao;
import com.fengzhuo.dashang.dao.DsUserDao;
import com.fengzhuo.dashang.pojo.entity.DsInbox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "deleteservice")
public class DeleteService {
    @Autowired
    private DsSentDao sentDao;
    @Autowired
    private DsInboxDao inboxDao;
    @Autowired
    private DsUserDao userDao;
    @Autowired
    private DsDraftDao draftDao;


    public int deleteMails(JSONObject jsonData) {
        JSONArray array = jsonData.getJSONArray("items");
        int code = 0;
        for(int i=0 ; i < array.size() ;i++) {
            //获取每一个JsonObject对象
            JSONObject Object = array.getJSONObject(i);
            int mailId = Object.getInteger("mailId");

            code = inboxDao.deleteByPrimaryKey(mailId);

        }

        return code;
    }
}
