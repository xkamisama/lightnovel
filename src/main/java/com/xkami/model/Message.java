package com.xkami.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Message implements Serializable{
    @Id@GeneratedValue
    private Long id;//消息id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;//消息接收者
    private Date date;//发送时间
    private String content;//消息内容
    private byte type;//消息类型
    @Column(columnDefinition = "tinyint default 0")
    private byte state;//消息状态

    public Message() {
    }

    public Message(User user, Date date, String content, byte state) {
        this.user = user;
        this.date = date;
        this.content = content;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }
}
