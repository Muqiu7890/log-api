package com.api.log.query;

import java.util.Date;

public class ExclogsQuery {
    private int id;
    private int type;
    private Date createTime;
    private String content;
    private int userId;
    private int exc;
    private String name;
    private String nickname;

    public ExclogsQuery() {
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public int getExc() {
        return exc;
    }

    public void setExc(int exc) {
        this.exc = exc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ExclogsQuery{" +
                "id=" + id +
                "type=" + type +
                ", createTime=" + createTime +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                ", exc=" + exc +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
