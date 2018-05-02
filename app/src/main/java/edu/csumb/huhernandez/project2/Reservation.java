package edu.csumb.huhernandez.project2;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "reservations",
        foreignKeys = {
                @ForeignKey(entity = User.class,
                        parentColumns = "mId",
                        childColumns = "user_id"),
                @ForeignKey(entity = Book.class,
                        parentColumns = "mBookId",
                        childColumns = "mBookId")},
        indices = {@Index(value = "user_id"),
                    @Index(value = "mBookId")
        })



public class Reservation {

    @PrimaryKey(autoGenerate = true)
    public int mId;

    @ColumnInfo(name = "user_id")
    public int mUserId;

    @ColumnInfo(name = "mBookId")
    public String mBookId;

    @ColumnInfo(name= "pickup_date")
    public String mpickupDate;

    @ColumnInfo(name ="return_date")
    public String mreturnDate;

    @ColumnInfo(name="fee")
    public double mFee;

    @ColumnInfo(name="status")
    public String mStatus;

    @ColumnInfo(name="transaction")
    public Date mTransaction;

    public Reservation (int mUserId, String mBookId, String mpickupDate, String mreturnDate, double mFee, String mStatus) {
        this.mUserId=mUserId;
        this.mBookId=mBookId;
        this.mpickupDate=mpickupDate;
        this.mreturnDate=mreturnDate;
        this.mFee=mFee;
        this.mStatus=mStatus;


    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public int getmUserId() {
        return mUserId;
    }

    public void setmUserId(int mUserId) {
        this.mUserId = mUserId;
    }

    public String getmBookId() {
        return mBookId;
    }

    public void setmBookId(String mBookId) {
        this.mBookId = mBookId;
    }

    public String getMpickupDate() {
        return mpickupDate;
    }

    public void setMpickupDate(String mpickupDate) {
        this.mpickupDate = mpickupDate;
    }

    public String getMreturnDate() {
        return mreturnDate;
    }

    public void setMreturnDate(String mreturnDate) {
        this.mreturnDate = mreturnDate;
    }

    public double getmFee() {
        return mFee;
    }

    public void setmFee(double mFee) {
        this.mFee = mFee;
    }




}