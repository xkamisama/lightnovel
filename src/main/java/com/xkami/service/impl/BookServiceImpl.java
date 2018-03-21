package com.xkami.service.impl;

import com.xkami.model.Book;
import com.xkami.model.repository.BookDao;
import com.xkami.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookServiceImpl implements BookService {
    @Resource
    BookDao bookDao;
    @Override
    public Book save(Book book) {
        return bookDao.save(book);
    }
}
