package edu.csumb.huhernandez.project2;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;


@Entity(tableName = "book")
public class Book {

    @PrimaryKey(autoGenerate = true)
    public int mBookId;

    @ColumnInfo(name="title")
    public String mTitle;

    @ColumnInfo(name = "author")
    public String mAuthor;

    @ColumnInfo(name = "isbn")
    public String mIsbn;

    @ColumnInfo(name = "rate")
    public double rate;

    @ColumnInfo(name = "avail")
    public String mAvailable;


    public Book(String title, String author, String isbn, double rate, String available) {
        mTitle = title;
        mAuthor = author;
        mIsbn = isbn;
        this.rate = rate;
        mAvailable = available;
    }

    public int getId() {
        return mBookId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmAuthor() {
        return mAuthor;
    }

    public String getmIsbn() {
        return mIsbn;
    }

    public double getRate() {
        return rate;
    }

    public String getmAvailable() {
        return mAvailable;
    }

    public void setmAvailable(String mAvailable) {
        this.mAvailable = mAvailable;
    }

    public void setmId(int mId) {
        this.mBookId = mBookId;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setmAuthor(String mAuthor) {
        this.mAuthor = mAuthor;
    }

    public void setmIsbn(String mIsbn) {
        this.mIsbn = mIsbn;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }
}
