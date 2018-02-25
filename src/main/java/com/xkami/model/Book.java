package com.xkami.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Integer id;//小说id
    @Column(unique = true)
    private String title;//小说标题
    @ManyToOne
    @JoinColumn(name="categoryId")
    private Category category;//小说种类
    @ManyToOne
    @JoinColumn(name="authorId")
    private Author author;//小说作者
    private String uri;//小说资源唯一标识
    private Date date;//小说录入时间
    private Boolean available;//小说状态（上下架）
    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name="BookTag",joinColumns={@JoinColumn(name="bookId")},inverseJoinColumns={@JoinColumn(name="tagId")})
    private List<Tag> tagList;//小说标签列表

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }
}
