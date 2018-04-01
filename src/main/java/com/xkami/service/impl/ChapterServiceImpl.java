package com.xkami.service.impl;

import com.xkami.model.Chapter;
import com.xkami.model.repository.ChapterDao;
import com.xkami.service.ChapterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class ChapterServiceImpl implements ChapterService {
    @Resource
    ChapterDao chapterDao;
    @Override
    public Chapter save(Chapter chapter) {
        return chapterDao.save(chapter);
    }
}
