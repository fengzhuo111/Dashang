package com.fengzhuo.dashang.pojo.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * ds_inbox
 * @author 
 */
public class DsInbox implements Serializable {
    /**
     * 邮件ID
     */
    private Integer mailId;

    private Integer userId;

    /**
     * 邮件主题
     */
    private String mailTheme;

    /**
     * 发件人编号
     */
    private String mailSender;

    /**
     * 日期
     */

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date mailDate;

    /**
     * 邮件类型
0：已读普通
1：未读普通
2：已读紧急
3：未读紧急
4：已读缓慢
5：未读缓慢
     */
    private Integer mailType;

    /**
     * 收件人编号
     */
    private String mailRecipient;

    private String mailDetial;

    private static final long serialVersionUID = 1L;

    public Integer getMailId() {
        return mailId;
    }

    public void setMailId(Integer mailId) {
        this.mailId = mailId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMailTheme() {
        return mailTheme;
    }

    public void setMailTheme(String mailTheme) {
        this.mailTheme = mailTheme;
    }

    public String getMailSender() {
        return mailSender;
    }

    public void setMailSender(String mailSender) {
        this.mailSender = mailSender;
    }

    public Date getMailDate() {
        return mailDate;
    }

    public void setMailDate(Date mailDate) {
        this.mailDate = mailDate;
    }

    public Integer getMailType() {
        return mailType;
    }

    public void setMailType(Integer mailType) {
        this.mailType = mailType;
    }

    public String getMailRecipient() {
        return mailRecipient;
    }

    public void setMailRecipient(String mailRecipient) {
        this.mailRecipient = mailRecipient;
    }

    public String getMailDetial() {
        return mailDetial;
    }

    public void setMailDetial(String mailDetial) {
        this.mailDetial = mailDetial;
    }
}