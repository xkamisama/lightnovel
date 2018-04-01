package com.xkami.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Entity
public class Chapter implements Serializable{
    @Id
    @GeneratedValue
    private Long id;//章节id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookId")
    private Book book;//所属小说
    @Lob
    @Basic(fetch=FetchType.LAZY)
    @Column(columnDefinition="TEXT",nullable=false)
    private String content;//章节内容
    private String title;//章节标题
    private Date date;//上传日期
    @Column(columnDefinition = "tinyint default 0")
    private byte state;//章节状态- 0 审核 1 审核通过
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "chapterId")
    private List<Comment> commentList;

    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", book=" + book +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", state=" + state +
                ", commentList=" + commentList +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setState(byte state) {
        this.state = state;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
