package com.zxh.ssh.dao;

import com.zxh.ssh.entity.User;

import java.util.List;

public interface UserDao {
    void save(User user);

    List<User> getList(String name);

    User login(User user);
}
