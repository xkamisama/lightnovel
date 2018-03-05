package com.xkami.model;

import javax.persistence.*;

@Entity
public class Author {
    @Id
    @GeneratedValue
    private Integer id;//作者id
    @OneToOne(fetch = FetchType.LAZY)
    private User user;//作者账户
    @Column(unique = true)
    private String name;//作者笔名
    private Boolean sex;//性别 0：女 1：男
    private String email;//邮箱
    private String introduction;//个人简介

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
