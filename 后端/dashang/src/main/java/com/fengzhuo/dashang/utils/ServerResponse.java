package com.fengzhuo.dashang.utils;

import com.fengzhuo.dashang.pojo.entity.DsUser;

public class ServerResponse<T> {
    private int status;  // status=0, 则成功
    private T data;
    private String msg;

    private ServerResponse(){}
    private ServerResponse(int status){
        this.status = status;
    }
    private ServerResponse(int status, T data){
        this.status = status;
        this.data = data;
    }

    private ServerResponse(int status, T data, String msg){
        this.status = status;
        this.data = data;
        this.msg = msg;
    }

    public static ServerResponse newInstance(int i, DsUser user, String msg){
        return new ServerResponse(0);
    }

    public static <T> ServerResponse newInstance(T data){
        return new ServerResponse(0,data);
    }

    public static ServerResponse newInstance(int status){
        return new ServerResponse(status);
    }

    public static <T> ServerResponse newInstance(T data, String msg){
        return new ServerResponse(0,data,msg);
    }

    public static ServerResponse newInstance(int status, String msg){
        return new ServerResponse(status,null, msg);
    }

    public static <T> ServerResponse newInstance(int status,T data, String msg){
        return new ServerResponse(status,data,msg);
    }

    public boolean isSuccess(){
        return this.status == 0;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
