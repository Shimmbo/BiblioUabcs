package com.jimmy.uabcs.bibliouabcs.models;

public class Author {

    //region Fields
    public Long _id;
    private int IdAuthor;
    private String Name;
    //endregion

    //region Getters & Setters

    public int getIdAuthor() {
        return IdAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        IdAuthor = idAuthor;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return _id.equals(author._id);

    }

    @Override
    public int hashCode() {
        return _id.hashCode();
    }

    //endregion
}
