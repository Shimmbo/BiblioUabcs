package com.jimmy.uabcs.bibliouabcs.models;

public class Publisher {
    //region Fields
    public Long _id;
    private String Name;
    private int IdPublisher;
    //endregion

    //region Getters & Setters


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getIdPublisher() {
        return IdPublisher;
    }

    public void setIdPublisher(int idPublisher) {
        IdPublisher = idPublisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        return _id.equals(publisher._id);

    }

    @Override
    public int hashCode() {
        return _id.hashCode();
    }

    //endregion
}
