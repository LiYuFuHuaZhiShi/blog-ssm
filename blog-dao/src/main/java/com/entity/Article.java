package com.entity;

import java.util.Date;
import java.util.List;

public class Article {
    private Integer aid;

    private String title;

    private Date time;

    private Integer contentId;

    private Integer typeId;

    private Integer authorId;

    //封装内容到实体类里
    private Content thecontent;//内容

    private Type thetype;//类别

    private Click theclick;//点击量

    private List<Keywords> keywordsList;//关键字

    private User user;//用户

    private List<Comment> commentList;//评论

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Content getThecontent() {
        return thecontent;
    }

    public void setThecontent(Content thecontent) {
        this.thecontent = thecontent;
    }

    public Type getThetype() {
        return thetype;
    }

    public void setThetype(Type thetype) {
        this.thetype = thetype;
    }

    public Click getTheclick() {
        return theclick;
    }

    public void setTheclick(Click theclick) {
        this.theclick = theclick;
    }

    public List<Keywords> getKeywordsList() {
        return keywordsList;
    }

    public void setKeywordsList(List<Keywords> keywordsList) {
        this.keywordsList = keywordsList;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }


    public Article() {

    }

    public Article(Integer aid, String title, Date time) {
        this.aid = aid;
        this.title = title;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Article{" +
                "aid=" + aid +
                ", title='" + title + '\'' +
                ", time=" + time +
                ", contentId=" + contentId +
                ", typeId=" + typeId +
                ", authorId=" + authorId +
                ", thecontent=" + thecontent +
                ", thetype=" + thetype +
                ", theclick=" + theclick +
                ", keywordsList=" + keywordsList +
                ", user=" + user +
                ", commentList=" + commentList +
                '}';
    }
}