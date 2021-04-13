package com.zxh.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;

    private String name;

    private String password;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
