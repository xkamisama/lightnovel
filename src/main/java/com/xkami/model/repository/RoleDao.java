package com.xkami.model.repository;

import com.xkami.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleDao extends CrudRepository<Role,Long> {
    /**
     * 保存角色信息
     * @param role
     * @return
     */
    Role save(Role role);

    /**
     * 通过id获取角色信息
     * @param id
     * @return
     */
    Role findById(Long id);

}
