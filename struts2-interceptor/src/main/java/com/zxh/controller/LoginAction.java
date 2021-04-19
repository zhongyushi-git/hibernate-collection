package com.zxh.controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zxh.entity.User;

public class LoginAction extends ActionSupport implements ModelDriven<User> {


    private User user = new User();

    @Override
    public User getModel() {
        return user;
    }

    public String login(){
        ActionContext context=ActionContext.getContext();
        if ("admin".equals(user.getUsername()) && "123456".equals(user.getPassword())) {
            // 将用户名和密码信息放入session对象中
            context.getSession().put("username", user.getUsername());
            context.getSession().put("password", user.getPassword());
            context.getSession().put("success", "用户登录成功！");
            return SUCCESS;
        } else {
            // 登录失败的错误信息
            context.getSession().put("error", "用户名或密码错误，请重新登录！");
            return INPUT;
        }
    }



}
