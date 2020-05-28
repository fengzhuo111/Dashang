//package com.fengzhuo.dashang.controller;
//
//import com.fengzhuo.dashang.dao.DsSentDao;
//import com.fengzhuo.dashang.dao.DsUserDao;
//import com.fengzhuo.dashang.pojo.entity.DsSent;
//import com.fengzhuo.dashang.pojo.entity.DsUser;
//import com.fengzhuo.dashang.service.MyService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//
//import javax.annotation.Resource;
//import java.util.Map;
//
//@Controller
//public class MyController {
//    @Resource
//    private MyService myService;
//
//    DsSent dsSent;
//
//    @ResponseBody
//    @RequestMapping("/hello")
//    public String hello(){
//        return "hello";
//    }
//
//    @RequestMapping(value = "/success", method = RequestMethod.POST)
//    public String success(Map<String,Object> map){
//        map.put("hello","你好");
//        return "success";
//    }
//
//    @ResponseBody
//    @RequestMapping("/a")
//    public String index(){
//        dsSent = myService.getSent();
//        System.out.println(dsSent.getSentDetial());
//        return "success";
//    }
//
//}
