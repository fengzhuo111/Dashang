package com.fengzhuo.dashang.controller;

import com.fengzhuo.dashang.pojo.entity.DsDraft;
import com.fengzhuo.dashang.pojo.entity.DsInbox;
import com.fengzhuo.dashang.pojo.entity.DsSent;
import com.fengzhuo.dashang.pojo.entity.PageResult;
import com.fengzhuo.dashang.service.ReceiveService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/message")
public class ReceiveController {
    @Autowired
    ReceiveService receiveService;

    @RequestMapping(value = "/unReadNum")
    public int countUnReadNum(@RequestParam("userName") String userName){
        return receiveService.countUnReadNum(userName);
    }

    @RequestMapping(value = "/mailNum")
    public int countMailNum(@RequestParam("userName") String userName){
        return receiveService.countMailNum(userName);
    }

    @RequestMapping(value = "/draftNum")
    public int countDraftNum(@RequestParam("userName") String userName){
        return receiveService.countDraftNum(userName);
    }

    @RequestMapping(value = "/sentNum")
    public int countSentNum(@RequestParam("userName") String userName){
        return receiveService.countSentNum(userName);
    }

//    @RequestMapping(value = "/inbox")
//    public String selectInbox(@RequestParam("userName") String userName){
//
//        return receiveService.selectInbox(userName);
//    }

    @RequestMapping(value = "/inboxs")
    public ResponseEntity<PageResult<DsInbox>> queryInbox(
            @RequestParam(value = "userName") String userName,
            @RequestParam(value = "page") Integer page,
            @RequestParam(value = "pageSize") Integer size
    ){
        PageResult<DsInbox> result = receiveService.queryInbox(userName, page,size);
        if(result == null || CollectionUtils.isEmpty(result.getItems())){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/drafts")
    public ResponseEntity<PageResult<DsDraft>> queryDraft(
            @RequestParam(value = "userName") String userName,
            @RequestParam(value = "page") Integer page,
            @RequestParam(value = "pageSize") Integer size
    ){
        PageResult<DsDraft> result = receiveService.queryDraft(userName, page,size);
        if(result == null || CollectionUtils.isEmpty(result.getItems())){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/sents")
    public ResponseEntity<PageResult<DsSent>> querySent(
            @RequestParam(value = "userName") String userName,
            @RequestParam(value = "page") Integer page,
            @RequestParam(value = "pageSize") Integer size
    ){
        PageResult<DsSent> result = receiveService.querySent(userName, page,size);
        if(result == null || CollectionUtils.isEmpty(result.getItems())){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

}
