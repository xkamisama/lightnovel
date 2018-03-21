package com.xkami.service.impl;

import com.xkami.model.Author;
import com.xkami.model.User;
import com.xkami.model.repository.AuthorDao;
import com.xkami.service.AuthorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class AuthorServiceImpl implements AuthorService {
    @Resource
    AuthorDao authorDao;
    @Override
    public Author addAuthor(Author author) {
        return authorDao.save(author);
    }

    @Override
    public Author findAuthorBy(User user) {
        return authorDao.findAuthorByUser(user
        );
    }
}
