package com.xkami.model.repository;


import com.xkami.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoDao extends CrudRepository<User,Long> {
    /**通过username查找用户信息;*/
    User findByUsername(String username);
}