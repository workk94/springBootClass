package com.acorn.thymeleafSample;

public class Member {
    private String username;
    private String email;

    // 기본 생성자
    public Member() {}

    // Getter 및 Setter
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
