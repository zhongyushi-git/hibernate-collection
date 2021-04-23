package com.zxh.ssh.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zxh.ssh.entity.User;
import com.zxh.ssh.service.UserService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

//@Setter
//@Getter
public class UserAction extends ActionSupport {

    private String msg;

    private String name;

    private String password;

    @Autowired
    private UserService userService;

//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }


    public String login() {
        Map<String, Object> session = ActionContext.getContext().getSession();
        if (name == null || password == null) {
            msg = "用户名或密码不能为空！";
            session.put("msg", msg);
            return "login_input";
        }
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        User loginUser = userService.login(user);
        if (loginUser != null) {
            session.put("loginUser", loginUser);
        } else {
            msg = "用户名或密码错误！";
            session.put("msg", msg);
            return "login_input";
        }
        return SUCCESS;
    }

    public String getList() {
        return SUCCESS;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
