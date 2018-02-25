package com.xkami.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Category {
    @Id
    @GeneratedValue
    private Integer id;//类别id
    @Column(unique = true)
    private String description;//类别描述
    private Boolean available;//类别状态
}
