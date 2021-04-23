package com.zxh.ssh.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zxh.ssh.entity.User;
import com.zxh.ssh.service.UserService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@Setter
@Getter
public class UserAction extends ActionSupport {

    private String msg;

    private String name;

    private String password;

    @Autowired
    private UserService userService;


    public String login() {
        ActionContext context = ActionContext.getContext();
        Map<String, Object> session = context.getSession();
        if (name == null || password == null) {
            context.put("msg", "用户名或密码不能为空！");
            return "login_input";
        }
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        User loginUser = userService.login(user);
        if (loginUser != null) {
            session.put("loginUser", loginUser);
            context.put("loginUser", loginUser);
        } else {
            context.put("msg", "用户名或密码错误！");
            return "login_input";
        }
        return SUCCESS;
    }


}
