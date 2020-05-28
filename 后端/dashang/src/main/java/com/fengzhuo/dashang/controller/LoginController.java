package com.fengzhuo.dashang.controller;

import com.fengzhuo.dashang.pojo.entity.DsUser;
import com.fengzhuo.dashang.service.LoginService;
import com.fengzhuo.dashang.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    LoginService service;


    @RequestMapping(value = "/register")
    public boolean register(@RequestParam("userName") String userName, @RequestParam("userPassword") String userPassword){
        return service.register(userName, userPassword);
    }

    @RequestMapping(value = "/login")
    public String login(@RequestParam("userName") String userName){
        return service.login(userName);
    }


    @RequestMapping("/testWeb")
    public ServerResponse login(@RequestParam("username") String username, @RequestParam("password")String password){
        DsUser user = new DsUser();
        user.setUserName(username);
        user.setUserPassword(password);

        user.setUserSex("0");
        return ServerResponse.newInstance(user);
    }
}
