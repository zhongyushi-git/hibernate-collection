package com.zxh.controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zxh.entity.User;

//@Setter
//@Getter
public class LoginAction extends ActionSupport implements ModelDriven<User> {

//    private String username; // 用户名
//    private String password; // 密码
//
//    public String login(){
//        ActionContext context=ActionContext.getContext();
//        if ("admin".equals(username) && "123456".equals(password)) {
//            // 将用户名和密码信息放入context对象中
//            context.put("username", username);
//            context.put("password", password);
//            context.put("success", "用户登录成功！");
//            return SUCCESS;
//        } else {
//            // 登录失败的错误信息
//            context.put("error", "用户名或密码错误，请重新登录！");
//            return ERROR;
//        }
//    }



//    private User user;

    private User user = new User();

    @Override
    public User getModel() {
        return user;
    }

    public String login(){
        ActionContext context=ActionContext.getContext();
        if ("admin".equals(user.getUsername()) && "123456".equals(user.getPassword())) {
            // 将用户名和密码信息放入context对象中
//            context.put("username", user.getUsername());
//            context.put("password", user.getPassword());
//            context.put("success", "用户登录成功！");
            context.getSession().put("username", user.getUsername());
            context.getSession().put("password", user.getPassword());
            context.getSession().put("success", "用户登录成功！");
            return SUCCESS;
        } else {
            // 登录失败的错误信息
            context.put("error", "用户名或密码错误，请重新登录！");
            return ERROR;
        }
    }



}
