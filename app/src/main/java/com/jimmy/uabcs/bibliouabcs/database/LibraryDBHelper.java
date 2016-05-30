package com.jimmy.uabcs.bibliouabcs.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.jimmy.uabcs.bibliouabcs.App;
import com.jimmy.uabcs.bibliouabcs.models.*;

import java.util.List;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

public class LibraryDBHelper extends SQLiteOpenHelper{
    //region database
    private static LibraryDBHelper mInstance;
    private static final String DATABASE_NAME = "library.db";
    private static final int DATABASE_VERSION = 1;

    static{
        cupboard().register(Author.class);
        cupboard().register(Book.class);
        cupboard().register(Booking.class);
        cupboard().register(Borrow.class);
        cupboard().register(Genre.class);
        cupboard().register(Publisher.class);
        cupboard().register(User.class);
    }

    private LibraryDBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static LibraryDBHelper getInstance(){
        if (mInstance == null){
            mInstance = new LibraryDBHelper(App.getContext());
        }
        return mInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        cupboard().withDatabase(db).createTables();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion != oldVersion){
            cupboard().withDatabase(db).upgradeTables();
        }
    }
    //endregion

    //region Book CRUD
    public static long saveBook(Book mBook){
        SQLiteDatabase db = getInstance().getWritableDatabase();
        return cupboard().withDatabase(db).put(mBook);
    }

    public static void saveBooks(List<Book> books){
        SQLiteDatabase db = getInstance().getWritableDatabase();
        cupboard().withDatabase(db).put(books);
    }

    public static Book getBook(long id){
        SQLiteDatabase db = getInstance().getReadableDatabase();
        return cupboard().withDatabase(db).query(Book.class).byId(id).get();
    }

    public static List<Book> getBooks(){
        SQLiteDatabase db = getInstance().getReadableDatabase();
        return cupboard().withDatabase(db).query(Book.class).list();
    }

    public static boolean deleteBook(Book mBook){
        SQLiteDatabase db = getInstance().getWritableDatabase();
        return cupboard().withDatabase(db).delete(mBook);
    }
    //endregion

    //region Author CRUD
    public static long saveAuthor(Author mAuthor){
        SQLiteDatabase db = getInstance().getWritableDatabase();
        return cupboard().withDatabase(db).put(mAuthor);
    }

    public static void saveAuthors(List<Author> authors){
        SQLiteDatabase db = getInstance().getWritableDatabase();
        cupboard().withDatabase(db).put(authors);
    }

    public static Author getAuthor(long id){
        SQLiteDatabase db = getInstance().getReadableDatabase();
        return cupboard().withDatabase(db).query(Author.class).byId(id).get();
    }

    public static List<Author> getAuthors(){
        SQLiteDatabase db = getInstance().getReadableDatabase();
        return cupboard().withDatabase(db).query(Author.class).list();
    }

    public static boolean deleteAuthor(Author mAuthor){
        SQLiteDatabase db = getInstance().getWritableDatabase();
        return cupboard().withDatabase(db).delete(mAuthor);
    }
    //endregion

    //region Booking CRUD
    public static long saveBooking(Booking mBooking){
        SQLiteDatabase db = getInstance().getWritableDatabase();
        return cupboard().withDatabase(db).put(mBooking);
    }

    public static void saveBookings(List<Booking> bookings){
        SQLiteDatabase db = getInstance().getWritableDatabase();
        cupboard().withDatabase(db).put(bookings);
    }

    public static Booking getBooking(long id){
        SQLiteDatabase db = getInstance().getReadableDatabase();
        return cupboard().withDatabase(db).query(Booking.class).byId(id).get();
    }

    public static List<Booking> getBookings(){
        SQLiteDatabase db = getInstance().getReadableDatabase();
        return cupboard().withDatabase(db).query(Booking.class).list();
    }

    public static boolean deleteBooking(Booking mBooking){
        SQLiteDatabase db = getInstance().getWritableDatabase();
        return cupboard().withDatabase(db).delete(mBooking);
    }
    //endregion

    //region Borrow CRUD
    public static long saveBorrow(Borrow mBorrow){
        SQLiteDatabase db = getInstance().getWritableDatabase();
        return cupboard().withDatabase(db).put(mBorrow);
    }

    public static void saveBorrows(List<Borrow> borrows){
        SQLiteDatabase db = getInstance().getWritableDatabase();
        cupboard().withDatabase(db).put(borrows);
    }

    public static Borrow getBorrow(long id){
        SQLiteDatabase db = getInstance().getReadableDatabase();
        return cupboard().withDatabase(db).query(Borrow.class).byId(id).get();
    }

    public static List<Borrow> getBorrows(){
        SQLiteDatabase db = getInstance().getReadableDatabase();
        return cupboard().withDatabase(db).query(Borrow.class).list();
    }

    public static boolean deleteBorrow(Borrow mBorrow){
        SQLiteDatabase db = getInstance().getWritableDatabase();
        return cupboard().withDatabase(db).delete(mBorrow);
    }
    //endregion

    //region Genre CRUD
    public static long saveGenre(Genre mGenre){
        SQLiteDatabase db = getInstance().getWritableDatabase();
        return cupboard().withDatabase(db).put(mGenre);
    }

    public static void saveGenres(List<Genre> genres){
        SQLiteDatabase db = getInstance().getWritableDatabase();
        cupboard().withDatabase(db).put(genres);
    }

    public static Genre getGenre(long id){
        SQLiteDatabase db = getInstance().getReadableDatabase();
        return cupboard().withDatabase(db).query(Genre.class).byId(id).get();
    }

    public static List<Genre> getGenres(){
        SQLiteDatabase db = getInstance().getReadableDatabase();
        return cupboard().withDatabase(db).query(Genre.class).list();
    }

    public static boolean deleteGenre(Genre mGenre){
        SQLiteDatabase db = getInstance().getWritableDatabase();
        return cupboard().withDatabase(db).delete(mGenre);
    }
    //endregion

    //region Publisher CRUD
    public static long savePublisher(Publisher mPublisher){
        SQLiteDatabase db = getInstance().getWritableDatabase();
        return cupboard().withDatabase(db).put(mPublisher);
    }

    public static void savePublishers(List<Publisher> publishers){
        SQLiteDatabase db = getInstance().getWritableDatabase();
        cupboard().withDatabase(db).put(publishers);
    }

    public static Publisher getPublisher(long id){
        SQLiteDatabase db = getInstance().getReadableDatabase();
        return cupboard().withDatabase(db).query(Publisher.class).byId(id).get();
    }

    public static List<Publisher> getPublishers(){
        SQLiteDatabase db = getInstance().getReadableDatabase();
        return cupboard().withDatabase(db).query(Publisher.class).list();
    }

    public static boolean deletePublisher(Publisher mPublisher){
        SQLiteDatabase db = getInstance().getWritableDatabase();
        return cupboard().withDatabase(db).delete(mPublisher);
    }
    //endregion

    //region User CRUD
    public static long saveUser(User mUser){
        SQLiteDatabase db = getInstance().getWritableDatabase();
        return cupboard().withDatabase(db).put(mUser);
    }

    public static void saveUsers(List<User> users){
        SQLiteDatabase db = getInstance().getWritableDatabase();
        cupboard().withDatabase(db).put(users);
    }

    public static User getUser(long id){
        SQLiteDatabase db = getInstance().getReadableDatabase();
        return cupboard().withDatabase(db).query(User.class).byId(id).get();
    }

    public static List<User> getUsers(){
        SQLiteDatabase db = getInstance().getReadableDatabase();
        return cupboard().withDatabase(db).query(User.class).list();
    }

    public static boolean deleteUser(User mUser){
        SQLiteDatabase db = getInstance().getWritableDatabase();
        return cupboard().withDatabase(db).delete(mUser);
    }
    //endregion
}
