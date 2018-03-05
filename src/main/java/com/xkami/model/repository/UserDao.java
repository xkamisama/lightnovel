package com.xkami.model.repository;


import com.xkami.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User,Long> {
    /**通过username查找用户信息;*/
    User findByUsername(String username);

    /**
     * 新建用户
     * @param user
     * @return
     */
    User save(User user);
}