package com.xkami.service.impl;

import com.xkami.model.Role;
import com.xkami.model.repository.RoleDao;
import com.xkami.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleServiceImpl implements RoleService{
    @Resource
    RoleDao roleDao;
    public Role findById(Long id){
        return roleDao.findById(id);
    }
}
