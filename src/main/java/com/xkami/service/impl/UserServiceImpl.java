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
    public User findByUsername(String username) {
        System.out.println("UserServiceImpl.findByUsername()");
        return userDao.findByUsername(username);
    }
}