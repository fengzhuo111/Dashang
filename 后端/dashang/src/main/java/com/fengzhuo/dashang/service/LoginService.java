package com.fengzhuo.dashang.service;

import com.fengzhuo.dashang.dao.DsUserDao;
import com.fengzhuo.dashang.pojo.entity.DsUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "loginservice")
public class LoginService {
    @Resource
    DsUserDao userDao;

    public boolean register(String userName, String userPassword) {
        DsUser user = userDao.selectUserByRealName(userName);
        if (user != null){
            return false;
        }else {
            DsUser record = new DsUser();
            record.setUserName(userName);
            record.setUserPassword(userPassword);
            record.setUserSex("1");
            userDao.insert(record);
            return true;
        }
    }

    public String login(String userName){
        DsUser user = userDao.selectUserByRealName(userName);
        if (user == null){
            return "UserNotFound";
        }else if(user.getUserPassword() == null){
            return "PasswordIsNull";
        }else{
            return user.getUserPassword();
        }

    }
}
