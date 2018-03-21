package com.xkami.model.repository;

import com.xkami.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookDao extends CrudRepository<Book,Long> {
    Book save(Book book);
}
