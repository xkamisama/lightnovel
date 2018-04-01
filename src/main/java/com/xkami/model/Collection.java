package com.xkami.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 用户收藏夹
 */
@Entity
public class Collection implements Serializable{
    @Id
    @GeneratedValue
    private Long id;//收藏id
    @ManyToOne
    private User user;//用户
    @ManyToOne
    private Book book;//收藏的书
    @ManyToOne
    private Chapter chapter;//书的章节
    @Column(columnDefinition = "tinyint default 0")
    private byte state;//收藏状态

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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }
}
