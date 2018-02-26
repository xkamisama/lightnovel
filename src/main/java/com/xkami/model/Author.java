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
