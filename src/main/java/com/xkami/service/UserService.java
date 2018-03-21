package com.xkami.service;


import com.xkami.model.User;

public interface UserService {
    /**
     * 保存用户信息
     * @param user
     * @return
     */
    User save(User user);
    /**通过username查找用户信息;*/
    User findByUsername(String username);

    /**
     * 通过密码查找用户信息
     * @param password
     * @return
     */
    User findByPassword(String password);
    /**
     * 通过邮箱查找用户信息
     */
    User findByEmail(String email);
    /**
     * 查找是否有重名
     */
    Long countByUsername(String username);
    /**
     * 查看是否有重复邮箱
     */
    Long countByEmail(String email);

}