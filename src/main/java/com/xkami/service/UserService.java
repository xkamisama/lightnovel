package com.xkami.service;


import com.xkami.model.User;

public interface UserService {
    /**通过username查找用户信息;*/
     User findByUsername(String username);
}