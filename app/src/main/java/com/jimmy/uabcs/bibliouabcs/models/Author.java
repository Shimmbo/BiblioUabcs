package com.jimmy.uabcs.bibliouabcs.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Author {

    //region Fields
    @Expose
    @SerializedName("id")
    public Long _id;
    @Expose
    private int IdAuthor;
    @Expose
    private String Name;
    @Expose
    private List<Book> Book;
    @Expose
    private String ImagePath;
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

    public List<com.jimmy.uabcs.bibliouabcs.models.Book> getBook() {
        return Book;
    }

    public void setBook(List<com.jimmy.uabcs.bibliouabcs.models.Book> book) {
        Book = book;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
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
