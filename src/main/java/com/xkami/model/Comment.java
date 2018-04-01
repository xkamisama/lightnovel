package com.xkami.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Comment implements Serializable{
    @Id
    @GeneratedValue
    private Long id;//评论id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chapterId")
    private Chapter chapter;//评论的章节
    private String content;//评论的内容
    @Column(columnDefinition = "tinyint default 0")
    private byte state;//评论的状态--0，正常，1，删除
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
