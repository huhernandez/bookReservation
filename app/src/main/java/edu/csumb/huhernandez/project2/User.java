package edu.csumb.huhernandez.project2;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Dao

@Entity(tableName = "users")
public class User {

    @PrimaryKey(autoGenerate = true)
    public int mId;

    @ColumnInfo(name="username")
    public String mUsername;

    @ColumnInfo(name = "password")
    public String mPassword;



    public User(String mUsername, String mPassword) {

        this.mUsername = mUsername;
        this.mPassword = mPassword;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmUsername() {
        return mUsername;
    }

    public void setmUsername(String mUsername) {
        this.mUsername = mUsername;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }
}
