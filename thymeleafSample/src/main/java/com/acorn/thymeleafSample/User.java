package com.acorn.thymeleafSample;

import lombok.Data;

@Data
 class User {
    private String username;
    private int age;

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }
}