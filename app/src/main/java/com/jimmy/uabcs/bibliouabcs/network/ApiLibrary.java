package com.jimmy.uabcs.bibliouabcs.network;

import com.jimmy.uabcs.bibliouabcs.models.*;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiLibrary {

    @POST("/login")
    Call<LoginResponse> login(@Body UserLogin login);

    @GET("authors/author/{id}")
    Call<Author> getAuthor(@Path("id") int id);

    @GET("authors/authors")
    Call<List<Author>> getAuthors();

    @GET("books/book/{id}")
    Call<Book> getBook(@Path("id") int id);

    @GET("books/books")
    Call<List<Book>> getBooks();

    @GET("books/genres")
    Call<List<Genre>> getGenres();

    @GET("publishers/publisher/{id}")
    Call<Publisher> getPublisher(@Path("id") int id);

    @GET("publishers/publishers")
    Call<List<Publisher>> getPublishers();

    @GET("users/userInfo/{id}")
    Call<User> getUserInfo(@Path("id") String id);

    @GET("users/users")
    Call<List<User>> getUsers();

    @GET("users/userDetails/{id}")
    Call<User> getUserDetails(@Path("id") String id);

    @GET("users/borrows/{id}")
    Call<Borrow> getBorrow(@Path("id") int id);
}
