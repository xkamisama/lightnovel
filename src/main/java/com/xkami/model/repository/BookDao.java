package com.xkami.model.repository;

import com.xkami.model.Book;
import com.xkami.model.Category;
import com.xkami.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface BookDao extends CrudRepository<Book,Long> {
    Book save(Book book);
    List<Book> findAllByState(byte state);
    Book findBookById(Long id);
    List<Book> findAllByAuthorUserAndState(User user,byte state);
    List<Book> findBooksByCategoryAndState(Category category, byte state, Pageable pageable);
}
