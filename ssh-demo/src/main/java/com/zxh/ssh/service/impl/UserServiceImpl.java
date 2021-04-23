package com.zxh.ssh.service.impl;

import com.zxh.ssh.dao.UserDao;
import com.zxh.ssh.entity.User;
import com.zxh.ssh.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    @Override
    public List<User> getList(String name) {
        return userDao.getList(name);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public User login(User user) {
        return userDao.login(user);
    }
}
