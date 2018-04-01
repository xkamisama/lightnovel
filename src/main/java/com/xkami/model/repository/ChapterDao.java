package com.xkami.model.repository;

import com.xkami.model.Chapter;
import org.springframework.data.repository.CrudRepository;

public interface ChapterDao extends CrudRepository<Chapter,Long> {
    Chapter save(Chapter chapter);
}
