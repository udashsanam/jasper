package com.learn.jasper.service;

import java.util.ArrayList;
import java.util.List;

public class UserDto {

    private Integer id;

    private String username;

    private String password;

    public UserDto(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static List<UserDto> getDat(){
        // Creating UserDto objects
        UserDto user1 = new UserDto(1, "john_doe", "password123");
        UserDto user2 = new UserDto(2, "jane_smith", "pass456");
        UserDto user3 = new UserDto(3, "sam_wilson", "secure789");

        // Adding to a list
        List<UserDto> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        return userList;
    }
}
