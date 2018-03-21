package com.xkami.model.repository;


import com.xkami.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User,Long> {
    /**通过username查找用户信息;*/
    User findByUsername(String username);

    /**
     * 通过邮箱查找用户信息
     * @param email
     * @return
     */
    User findByEmail(String email);

    /**
     * 通过密码查找用户
     * @param password
     * @return
     */
    User findByPassword(String password);
    /**
     * 新建用户
     * @param user
     * @return
     */
    User save(User user);

    /**
     * 通过用户名查找是否重复
     * @param username
     * @return
     */
    Long countByUsername(String username);

    /**
     * 查看邮箱被使用次数
     * @param email
     * @return
     */
    Long countByEmail(String email);
}