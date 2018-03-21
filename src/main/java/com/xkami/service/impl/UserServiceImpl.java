package com.xkami.service.impl;


import com.xkami.model.User;
import com.xkami.model.repository.UserDao;
import com.xkami.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public User findByPassword(String password) {
        return userDao.findByPassword(password);
    }

    @Override
    public User findByUsername(String username) {
        System.out.println("UserServiceImpl.findByUsername()");
        return userDao.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public Long countByUsername(String username) {
        return userDao.countByUsername(username);
    }

    @Override
    public Long countByEmail(String email) {
        return userDao.countByEmail(email);
    }
}