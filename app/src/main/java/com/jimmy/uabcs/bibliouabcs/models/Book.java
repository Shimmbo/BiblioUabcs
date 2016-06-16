package com.jimmy.uabcs.bibliouabcs.models;

import android.text.TextUtils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class Book {

    //region Fields
    @Expose
    @SerializedName("id")
    public Long _id;
    @Expose
    private int IdBook;
    @Expose
    private int IdPublisher;
    @Expose
    private String Name;
    @Expose
    private Date Year;
    @Expose
    private int Pages;
    @Expose
    private int Quantity;
    @Expose
    private int Edition;
    @Expose
    private String Place;
    @Expose
    private String ISBN;
    @Expose
    private String ISSN;
    @Expose
    private String Path;
    @Expose
    private String ImagePath;
    @Expose
    private List<Author> Author;
    @Expose
    private List<Genre> Genre;
    @Expose
    private Publisher Publisher;
    //endregion

    //region Getters & Setters

    public int getIdBook() {
        return IdBook;
    }

    public void setIdBook(int idBook) {
        IdBook = idBook;
    }

    public int getIdPublisher() {
        return IdPublisher;
    }

    public void setIdPublisher(int idPublisher) {
        IdPublisher = idPublisher;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Date getYear() {
        return Year;
    }

    public void setYear(Date year) {
        Year = year;
    }

    public int getPages() {
        return Pages;
    }

    public void setPages(int pages) {
        Pages = pages;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getEdition() {
        return Edition;
    }

    public void setEdition(int edition) {
        Edition = edition;
    }

    public String getPlace() {
        return Place;
    }

    public void setPlace(String place) {
        Place = place;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getISSN() {
        return ISSN;
    }

    public void setISSN(String ISSN) {
        this.ISSN = ISSN;
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String path) {
        Path = path;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }

    public List<com.jimmy.uabcs.bibliouabcs.models.Author> getAuthor() {
        return Author;
    }

    public void setAuthor(List<com.jimmy.uabcs.bibliouabcs.models.Author> author) {
        Author = author;
    }

    public List<com.jimmy.uabcs.bibliouabcs.models.Genre> getGenre() {
        return Genre;
    }

    public void setGenre(List<com.jimmy.uabcs.bibliouabcs.models.Genre> genre) {
        Genre = genre;
    }

    public com.jimmy.uabcs.bibliouabcs.models.Publisher getPublisher() {
        return Publisher;
    }

    public void setPublisher(com.jimmy.uabcs.bibliouabcs.models.Publisher publisher) {
        Publisher = publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return _id.equals(book._id);

    }

    @Override
    public int hashCode() {
        return _id.hashCode();
    }

    //endregion

    //region Utils
    public String genreJoin() {
        String[] arrayNames = new String[Genre.size()];
        for (int i = 0; i < Genre.size(); i++) {
            arrayNames[i] = Genre.get(i).getName();
        }
        return TextUtils.join(",", arrayNames);
    }

    public String authorJoin() {
        String[] arrayNames = new String[Author.size()];
        for (int i = 0; i < Author.size(); i++) {
            arrayNames[i] = Author.get(i).getName();
        }
        return TextUtils.join(",", arrayNames);
    }
    //endregion
}
