package com.xkami.model;

import javax.persistence.*;
import java.util.List;
@Entity
public class Chapter {
    @Id
    @GeneratedValue
    private Integer id;//章节id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookId")
    private Book book;//所属小说
    @Lob
    @Basic(fetch=FetchType.LAZY)
    @Column(columnDefinition="TEXT",nullable=false)
    private String content;//章节内容
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "chapterId")
    private List<Comment> commentList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
