package com.jimmy.uabcs.bibliouabcs.models;

import java.util.Date;

public class Booking {

    //region Fields
    public Long _id;
    private int IdBooking;
    private Date mDate;
    private byte State;
    private String IdUser;
    private int IdBook;
    //endregion

    //region Getters & Setters
    public int getIdBooking() {
        return IdBooking;
    }

    public void setIdBooking(int idBooking) {
        IdBooking = idBooking;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public byte getState() {
        return State;
    }

    public void setState(byte state) {
        State = state;
    }

    public String getIdUser() {
        return IdUser;
    }

    public void setIdUser(String idUser) {
        IdUser = idUser;
    }

    public int getIdBook() {
        return IdBook;
    }

    public void setIdBook(int idBook) {
        IdBook = idBook;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Booking booking = (Booking) o;

        return _id.equals(booking._id);

    }

    @Override
    public int hashCode() {
        return _id.hashCode();
    }

    //endregion
}
