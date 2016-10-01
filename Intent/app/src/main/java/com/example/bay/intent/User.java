package com.example.bay.intent;

import java.io.Serializable;

/**
 * Created by Bay on 10/1/2016.
 */
public class User implements Serializable{
    String username,password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
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
}
