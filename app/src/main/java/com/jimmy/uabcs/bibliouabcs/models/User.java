package com.jimmy.uabcs.bibliouabcs.models;

import java.util.Date;

public class User {
    //region Fields
    public Long _id;
    private String IdUser;
    private String Name;
    private String LastName_1;
    private String LastName_2;
    private String ControlNumber;
    private String Address;
    private String Phone;
    private boolean Registered;
    private String Email;
    private Date LastLogin;
    //endregion

    //region Getters & Setters
    public String getIdUser() {
        return IdUser;
    }

    public void setIdUser(String idUser) {
        IdUser = idUser;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName_1() {
        return LastName_1;
    }

    public void setLastName_1(String lastName_1) {
        LastName_1 = lastName_1;
    }

    public String getLastName_2() {
        return LastName_2;
    }

    public void setLastName_2(String lastName_2) {
        LastName_2 = lastName_2;
    }

    public String getControlNumber() {
        return ControlNumber;
    }

    public void setControlNumber(String controlNumber) {
        ControlNumber = controlNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public boolean isRegistered() {
        return Registered;
    }

    public void setRegistered(boolean registered) {
        Registered = registered;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Date getLastLogin() {
        return LastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        LastLogin = lastLogin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return _id.equals(user._id);

    }

    @Override
    public int hashCode() {
        return _id.hashCode();
    }

    //endregion
}
