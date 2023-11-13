package com.example.demo;

import lombok.Data;

@Data
public class Reader {
    private Integer id;
    private String username;
    private String email;
    private Address address;

}
