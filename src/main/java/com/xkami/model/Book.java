package com.xkami.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;//小说id
    @Column(unique = true)
    private String title;//小说标题
    @ManyToOne
    @JoinColumn(name="categoryId")
    private Category category;//小说种类
    @ManyToOne
    @JoinColumn(name="authorId")
    private Author author;//小说作者
    private Date date;//小说录入时间
    @Column(columnDefinition = "0")
    private byte state;//小说状态（上下架）:0:未审核，1：上架，2下架
    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name="BookTag",joinColumns={@JoinColumn(name="bookId")},inverseJoinColumns={@JoinColumn(name="tagId")})
    private List<Tag> tagList;//小说标签列表
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookId")
    private List<Chapter> chapterList;//章节列表
    private String description;//小说简介
    private String postUrl;//封面路径

    public String getPostUrl() {
        return postUrl;
    }

    public void setPostUrl(String postUrl) {
        this.postUrl = postUrl;
    }

    public void setState(byte state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category=" + category +
                ", author=" + author +
                ", date=" + date +
                ", state=" + state +
                ", tagList=" + tagList +
                ", chapterList=" + chapterList +
                ", description='" + description + '\'' +
                '}';
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public List<Chapter> getChapterList() {
        return chapterList;
    }

    public void setChapterList(List<Chapter> chapterList) {
        this.chapterList = chapterList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }
}
