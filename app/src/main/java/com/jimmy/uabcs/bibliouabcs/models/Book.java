package com.jimmy.uabcs.bibliouabcs.models;

import java.util.Date;

public class Book {

    //region Fields
    public Long _id;
    private int IdBook;
    private int IdPublisher;
    private String Name;
    private Date Year;
    private int Pages;
    private int Quantity;
    private int Edition;
    private String Place;
    private String ISBN;
    private String ISSN;
    private String Path;
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
}
