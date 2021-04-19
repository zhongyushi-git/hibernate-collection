package com.zxh.controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

public class OgnlController  extends ActionSupport {

    public String execute(){
        ActionContext context = ActionContext.getContext();
        HttpServletRequest request = ServletActionContext.getRequest();
        context.getSession().put("msg","我是session信息");
        context.getApplication().put("msg","我是application信息");
        request.setAttribute("msg","我是request信息");
        return SUCCESS;
    }
}
