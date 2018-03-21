package com.xkami.model.repository;

import com.xkami.model.Author;
import com.xkami.model.User;
import org.springframework.data.repository.CrudRepository;

public interface AuthorDao extends CrudRepository<Author,Long>{
    Author save(Author author);
    Author findAuthorByUser(User user);
}
