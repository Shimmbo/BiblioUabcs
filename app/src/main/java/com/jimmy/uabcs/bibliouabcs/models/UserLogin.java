package com.jimmy.uabcs.bibliouabcs.models;

import java.util.Date;

public class UserLogin {
    //region Fields
    private String username;
    private String password;
    private String grantType;
    public UserLogin(){
        grantType = "password";
    }
    //endregion

    //region Getters & Setters

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

    public String getGrantType() {
        return grantType;
    }
    //endregion
}
