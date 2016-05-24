package com.jimmy.uabcs.bibliouabcs.models;

public class Genre {

    //region Fields
    public Long _id;
    private String Name;
    private int IdGenre;
    //endregion

    //region Getters & Setters

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getIdGenre() {
        return IdGenre;
    }

    public void setIdGenre(int idGenre) {
        IdGenre = idGenre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Genre genre = (Genre) o;

        return _id.equals(genre._id);

    }

    @Override
    public int hashCode() {
        return _id.hashCode();
    }

    //endregion
}
