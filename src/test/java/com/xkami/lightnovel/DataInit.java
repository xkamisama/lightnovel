package com.xkami.lightnovel;

import com.xkami.model.Category;
import com.xkami.model.Role;
import com.xkami.model.repository.CategoryDao;
import com.xkami.model.repository.RoleDao;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
@RunWith(SpringRunner.class)
@SpringBootTest
public class DataInit {
    @Resource
    RoleDao roleDao;
    @Resource
    CategoryDao categoryDao;
    @Test
    public void InitRole() {
        roleDao.save(new Role("管理员"));
        roleDao.save(new Role("读者"));
        roleDao.save(new Role("作者"));
    }

    @Test
    public void InitCategory() {
        categoryDao.save(new Category("热血"));
        categoryDao.save(new Category("冒险"));
        categoryDao.save(new Category("魔幻"));
        categoryDao.save(new Category("校园"));
        categoryDao.save(new Category("武侠"));
        categoryDao.save(new Category("同人"));
        categoryDao.save(new Category("爱情"));
        categoryDao.save(new Category("搞笑"));
        categoryDao.save(new Category("科幻"));
        categoryDao.save(new Category("推理"));
        categoryDao.save(new Category("社会"));
        categoryDao.save(new Category("惊悚"));
        categoryDao.save(new Category("运动"));
        categoryDao.save(new Category("机战"));
        categoryDao.save(new Category("温情"));

    }
}
