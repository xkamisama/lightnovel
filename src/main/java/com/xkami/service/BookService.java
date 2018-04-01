package com.xkami.service;

import com.xkami.model.Book;
import com.xkami.model.Category;
import com.xkami.model.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    Book save(Book book);
    List<Book> findAllByState(byte state);
    Book findBookById(Long id);
    List<Book> findAllByAuthorUserAndState(User user, byte state);
    List<Book> findBooksByCategoryAndState(Category category, byte state, Pageable pageable);
}
