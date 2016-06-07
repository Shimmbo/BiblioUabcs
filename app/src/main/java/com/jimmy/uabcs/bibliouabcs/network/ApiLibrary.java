package com.jimmy.uabcs.bibliouabcs.network;

import com.jimmy.uabcs.bibliouabcs.models.*;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

public interface ApiLibrary {

    @POST("login")
    Observable<LoginResponse> login(@Body UserLogin login);

    @POST("account/register")
    Observable<GeneralResponse> register(@Body User mUser);

    @GET("authors/author/{id}")
    Observable<Author> getAuthor(@Path("id") int id);

    @GET("authors/authors")
    Observable<List<Author>> getAuthors();

    @GET("books/book/{id}")
    Observable<Book> getBook(@Path("id") int id);

    @GET("books/books")
    Observable<List<Book>> getBooks();

    @GET("books/genres")
    Observable<List<Genre>> getGenres();

    @GET("publishers/publisher/{id}")
    Observable<Publisher> getPublisher(@Path("id") int id);

    @GET("publishers/publishers")
    Observable<List<Publisher>> getPublishers();

    @GET("users/userInfo/{id}")
    Observable<User> getUserInfo(@Path("id") String id);

    @GET("users/users")
    Observable<List<User>> getUsers();

    @GET("users/userDetails/{id}")
    Observable<User> getUserDetails(@Path("id") String id);

    @GET("users/borrows/{id}")
    Observable<Borrow> getBorrow(@Path("id") int id);
}
