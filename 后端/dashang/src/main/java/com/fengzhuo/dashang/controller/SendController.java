package com.fengzhuo.dashang.controller;

import com.alibaba.fastjson.JSONObject;
import com.fengzhuo.dashang.pojo.entity.DsDraft;
import com.fengzhuo.dashang.service.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/save")
public class SendController {
    @Autowired
    SendService sendService;

    @RequestMapping(value = "/mail", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public int saveMail(@RequestBody JSONObject jsonData){

        return sendService.saveMail(jsonData);
    }

    @RequestMapping(value = "/draft", method = RequestMethod.POST,  produces = "application/json;charset=UTF-8")
    public int saveDraft(@RequestBody JSONObject jsonData){
        return sendService.saveDraft(jsonData);
    }
}
