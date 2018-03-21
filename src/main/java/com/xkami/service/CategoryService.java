package com.xkami.service;

import com.xkami.model.Category;

import java.util.List;

public interface CategoryService {
    Category save(Category category);
    List<Category> findAllByAvailable(Boolean available);
}
