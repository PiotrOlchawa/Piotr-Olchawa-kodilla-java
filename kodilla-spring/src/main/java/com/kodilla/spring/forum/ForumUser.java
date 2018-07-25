package com.kodilla.spring.forum;

import org.springframework.stereotype.Component;

@Component
public class ForumUser {

    private String username;

    public ForumUser() {
        this.username = new String("John Smith");
    }

    public String getUsername() {
        return username;
    }
}
