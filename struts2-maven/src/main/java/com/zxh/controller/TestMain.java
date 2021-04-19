package com.zxh.controller;

import com.zxh.entity.User;
import ognl.Ognl;
import ognl.OgnlException;

public class TestMain {

    public static void main(String[] args) {
        User user = new User();
        user.setUsername("张三");
        try {
            System.out.println(Ognl.getValue("username", user));
        } catch (OgnlException e) {
            e.printStackTrace();
        }
    }

    public static String staticValue="我是静态值，hello";
    public static void testMethod(){
        System.out.println("我是静态方法，我被执行了");
    }
}
