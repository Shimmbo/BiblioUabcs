package com.jimmy.uabcs.bibliouabcs.network;

import com.jimmy.uabcs.bibliouabcs.models.*;

import java.util.List;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.jimmy.uabcs.bibliouabcs.App.getApi;

public class LibraryService {
    public static void login(UserLogin mLogin, Subscriber<LoginResponse> subscriber) {
         getApi().login(mLogin.getUsername(), mLogin.getPassword(), mLogin.getGrant_type())
                 .subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(subscriber);
    }

    public static void register(User mUser, Subscriber<GeneralResponse> subscriber) {
        getApi().register(mUser)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void getAuthor(int id, Subscriber<Author> subscriber){
        getApi().getAuthor(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void getAuthors(Subscriber<List<Author>> subscriber){
        getApi().getAuthors()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void getBook(int id, Subscriber<Book> subscriber){
        getApi().getBook(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void getBooks(Subscriber<List<Book>> subscriber){
        getApi().getBooks()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void getGenres(Subscriber<List<Genre>> subscriber){
        getApi().getGenres()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void getPublisher(int id,Subscriber<Publisher> subscriber){
        getApi().getPublisher(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void getPublishers(Subscriber<List<Publisher>> subscriber){
        getApi().getPublishers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void getUserInfo(String id,Subscriber<User> subscriber){
        getApi().getUserInfo(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
