package com.zxh.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.HashSet;
import java.util.Set;

//@Data
@Setter
@Getter
@ToString
@Accessors(chain = true)
public class Clazz {

    private Integer id;

    private String name;

    private Set<Student> students = new HashSet<>();

}
