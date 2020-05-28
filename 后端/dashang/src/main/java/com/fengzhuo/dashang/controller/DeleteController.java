package com.fengzhuo.dashang.controller;

import com.alibaba.fastjson.JSONObject;
import com.fengzhuo.dashang.service.DeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/delete")
public class DeleteController {
    @Autowired
    DeleteService deleteService;

    @RequestMapping(value = "/mails", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public int saveMail(@RequestBody JSONObject jsonData){

        return deleteService.deleteMails(jsonData);
    }

}
