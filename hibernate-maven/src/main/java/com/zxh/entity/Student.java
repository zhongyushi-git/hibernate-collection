package com.zxh.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

//@Data
@Setter
@Getter
@ToString
@Accessors(chain = true)
public class Student {

    private Integer id;

    private String name;

    private Clazz clazz;

}