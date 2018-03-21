package com.xkami.service.impl;

import com.xkami.model.Category;
import com.xkami.model.repository.CategoryDao;
import com.xkami.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService{
    @Resource
    CategoryDao categoryDao;
    @Override
    public Category save(Category category) {
        return categoryDao.save(category);
    }

    @Override
    public List<Category> findAllByAvailable(Boolean available) {
        return categoryDao.findAllByAvailable(available);
    }
}
