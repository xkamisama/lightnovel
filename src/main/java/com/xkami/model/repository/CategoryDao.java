package com.xkami.model.repository;

import com.xkami.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryDao extends CrudRepository<Category,Long> {
    Category save(Category category);
    List<Category> findAllByAvailable(Boolean available);
}
