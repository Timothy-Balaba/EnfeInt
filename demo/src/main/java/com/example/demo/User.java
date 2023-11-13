package com.example.demo;

import lombok.Data;

@Data
public class User {
    public User(String username, String email, String zipcode) {
        this.username = username;
        this.email = email;
        this.zipcode = zipcode;
    }

    public User(Integer id, String username, String email, String zipcode) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.zipcode = zipcode;
    }

    private Integer id;
    private String username;
    private String email;
    private String zipcode;
}
