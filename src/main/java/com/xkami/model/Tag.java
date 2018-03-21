package com.xkami.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Tag implements Serializable {
    @Id
    @GeneratedValue
    private Long id;//小说标签的id
    @Column(unique = true)
    private String description;//标签的描述
    private boolean avaliable;//标签是否可用
    @ManyToMany(fetch= FetchType.LAZY)
    @JoinTable(name="BookTag",joinColumns={@JoinColumn(name="tagId")},inverseJoinColumns={@JoinColumn(name="bookId")})
    private List<Book> bookList;
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvaliable() {
        return avaliable;
    }

    public void setAvaliable(boolean avaliable) {
        this.avaliable = avaliable;
    }

    public Long getId() {
        return id;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
