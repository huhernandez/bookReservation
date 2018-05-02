package edu.csumb.huhernandez.project2;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao

public interface BookDao {

    @Query("select count(*) from book")
    int count();

//    @Query("select * from book where mBookId=:mbookId")
//    List<Book> getAllBooks();

    @Query("select title from book")
    List<String> getAllBookTitles();

    @Query("select * from Book where isbn = :mIsbn")
    Book findBookByIsbn(String mIsbn);

    @Insert
    long addBook(Book book);
}
