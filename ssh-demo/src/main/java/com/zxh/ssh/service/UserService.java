package com.zxh.ssh.service;

import com.zxh.ssh.entity.User;

import java.util.List;

public interface UserService {

    List<User> getList(String name);

    void save(User user);

    User login(User user);

}
