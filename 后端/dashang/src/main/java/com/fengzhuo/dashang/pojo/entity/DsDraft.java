package com.fengzhuo.dashang.pojo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * ds_draft
 * @author 
 */
public class DsDraft implements Serializable {
    /**
     * 草稿ID
     */
    private Integer draftId;

    private Integer userId;

    private String draftTheme;

    /**
     * 发件人ID
     */
    private String draftSender;

    /**
     * 日期
     */
    private Date draftDate;

    /**
     * 收件人ID
     */
    private String draftRecipient;

    /**
     * 草稿正文
     */
    private String draftDetial;

    private static final long serialVersionUID = 1L;

    public Integer getDraftId() {
        return draftId;
    }

    public void setDraftId(Integer draftId) {
        this.draftId = draftId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDraftTheme() {
        return draftTheme;
    }

    public void setDraftTheme(String draftTheme) {
        this.draftTheme = draftTheme;
    }

    public String getDraftSender() {
        return draftSender;
    }

    public void setDraftSender(String draftSender) {
        this.draftSender = draftSender;
    }

    public Date getDraftDate() {
        return draftDate;
    }

    public void setDraftDate(Date draftDate) {
        this.draftDate = draftDate;
    }

    public String getDraftRecipient() {
        return draftRecipient;
    }

    public void setDraftRecipient(String draftRecipient) {
        this.draftRecipient = draftRecipient;
    }

    public String getDraftDetial() {
        return draftDetial;
    }

    public void setDraftDetial(String draftDetial) {
        this.draftDetial = draftDetial;
    }
}