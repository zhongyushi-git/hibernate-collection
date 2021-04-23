package com.zxh.config;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class PrivilegeInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        ActionContext context = actionInvocation.getInvocationContext();
        //获取用户登录信息
        Object username = context.getSession().get("username");
        if (null == username) {
            context.put("msg", "您还未登录，请先登录！");
            //返回登录请求
            return Action.LOGIN;
        } else {
            // 放行，向下执行
            return actionInvocation.invoke();
        }
    }
}
