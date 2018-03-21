package com.xkami.service;

import com.xkami.model.Author;
import com.xkami.model.User;

public interface AuthorService {
    Author addAuthor(Author author);
    Author findAuthorBy(User user);
}
