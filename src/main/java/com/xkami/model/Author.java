package com.xkami.model;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.NotEmpty;
import org.omg.CORBA.DefinitionKind;

import javax.persistence.*;

@Entity
public class Author {
    @Id
    @GeneratedValue
    private Long id;//作者id
    @OneToOne(fetch = FetchType.LAZY)
    private User user;//作者账户
    @Column(unique = true)
    @NotEmpty(message = "姓名不能为空")
    private String name;//作者笔名
    private Boolean sex;//性别 0：女 1：男
    @NotEmpty(message = "个人简介不能为空")
    private String introduction;//个人简介
    @Column(columnDefinition = "0")
    private byte state;

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


    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
