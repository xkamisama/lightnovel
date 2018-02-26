package com.xkami.model;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Integer id;//评论id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chapterId")
    private Chapter chapter;//评论的章节
    private String content;//评论的内容

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
