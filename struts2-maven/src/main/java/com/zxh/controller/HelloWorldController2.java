package com.zxh.controller;

import com.opensymphony.xwork2.Action;

public class HelloWorldController2  implements Action {

    @Override
    public String execute() throws Exception {
        return ERROR;
    }

    public String toSuccess(){
        return SUCCESS;
    }
}
