package com.xkami.service.impl;

import com.xkami.model.Book;
import com.xkami.model.Category;
import com.xkami.model.User;
import com.xkami.model.repository.BookDao;
import com.xkami.service.BookService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Resource
    BookDao bookDao;

    @Override
    public List<Book> findAllByAuthorUserAndState(User user, byte state) {
        return bookDao.findAllByAuthorUserAndState(user, state);
    }

    @Override
    public List<Book> findBooksByCategoryAndState(Category category, byte state, Pageable pageable) {
        return bookDao.findBooksByCategoryAndState(category, state, pageable);
    }

    @Override
    public Book save(Book book) {
        return bookDao.save(book);
    }

    @Override
    public List<Book> findAllByState(byte state) {
        return bookDao.findAllByState(state);
    }

    @Override
    public Book findBookById(Long id) {
        return bookDao.findBookById(id);
    }
}
