package com.xkami.model;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.NotEmpty;
import org.omg.CORBA.DefinitionKind;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Author implements Serializable{
    @Id
    @GeneratedValue
    private Long id;//作者id
    @OneToOne(fetch = FetchType.LAZY)
    private User user;//作者账户
    @Column(unique = true)
    @NotEmpty(message = "姓名不能为空")
    private String name;//姓名
    @NotEmpty(message = "电话号码不能为空")
    private String phone;//电话
    @Column(columnDefinition = "tinyint default 0")
    private byte state;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
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
