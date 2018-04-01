package com.xkami.model;

import javax.persistence.*;
import java.io.Serializable;


/**
 * 小说标签对应表
 */
@Entity
public class BookTag implements Serializable{
    @Id
    @GeneratedValue
    private Long id;
    private Integer count;//标记次数
    @ManyToOne
    @JoinColumn(name="bookId")
    private Book book;
    @ManyToOne
    @JoinColumn(name="tagId")
    private Tag tag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
