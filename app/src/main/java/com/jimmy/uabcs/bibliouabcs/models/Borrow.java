package com.jimmy.uabcs.bibliouabcs.models;

import java.util.Date;

public class Borrow {

    //region Fields
    public Long _id;
    private int IdBorrow;
    private Date Borrowed;
    private Date Returned;
    private int Prolongations;
    private String IdUser;
    private boolean State;
    //endregion

    //region Getters & Setters
    public int getIdBorrow() {
        return IdBorrow;
    }

    public void setIdBorrow(int idBorrow) {
        IdBorrow = idBorrow;
    }

    public Date getBorrowed() {
        return Borrowed;
    }

    public void setBorrowed(Date borrowed) {
        Borrowed = borrowed;
    }

    public Date getReturned() {
        return Returned;
    }

    public void setReturned(Date returned) {
        Returned = returned;
    }

    public int getProlongations() {
        return Prolongations;
    }

    public void setProlongations(int prolongations) {
        Prolongations = prolongations;
    }

    public String getIdUser() {
        return IdUser;
    }

    public void setIdUser(String idUser) {
        IdUser = idUser;
    }

    public boolean isState() {
        return State;
    }

    public void setState(boolean state) {
        State = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Borrow borrow = (Borrow) o;

        return _id.equals(borrow._id);

    }

    @Override
    public int hashCode() {
        return _id.hashCode();
    }

    //endregion
}
