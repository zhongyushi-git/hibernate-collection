package com.zxh.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@ToString
@Accessors(chain = true)
public class Stud {

    private Integer id;

    private String name;

    private Set<Course> courses = new HashSet<>();
}
