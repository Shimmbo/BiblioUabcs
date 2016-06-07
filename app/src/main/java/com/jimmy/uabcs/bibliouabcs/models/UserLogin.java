package com.jimmy.uabcs.bibliouabcs.models;

import com.google.gson.annotations.Expose;

public class UserLogin {
    //region Fields
    @Expose
    private String username;
    @Expose
    private String password;
    @Expose
    private String grant_type;
    public UserLogin(){
        grant_type = "password";
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

    public String getGrant_type() {
        return grant_type;
    }
    //endregion
}
