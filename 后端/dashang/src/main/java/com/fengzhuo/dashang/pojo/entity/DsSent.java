package com.fengzhuo.dashang.pojo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * ds_sent
 * @author 
 */
public class DsSent implements Serializable {
    private Integer sentId;

    private Integer userId;

    private String sentTheme;

    private String sentSender;

    private Date sentDate;

    private String sentRecipient;

    private String sentDetial;

    private static final long serialVersionUID = 1L;

    public Integer getSentId() {
        return sentId;
    }

    public void setSentId(Integer sentId) {
        this.sentId = sentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSentTheme() {
        return sentTheme;
    }

    public void setSentTheme(String sentTheme) {
        this.sentTheme = sentTheme;
    }

    public String getSentSender() {
        return sentSender;
    }

    public void setSentSender(String sentSender) {
        this.sentSender = sentSender;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    public String getSentRecipient() {
        return sentRecipient;
    }

    public void setSentRecipient(String sentRecipient) {
        this.sentRecipient = sentRecipient;
    }

    public String getSentDetial() {
        return sentDetial;
    }

    public void setSentDetial(String sentDetial) {
        this.sentDetial = sentDetial;
    }
}