package edu.csumb.huhernandez.project2;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import java.util.Date;

@Entity(tableName = "transaction",
        foreignKeys = {
                @ForeignKey(entity = User.class,
                        parentColumns = "mId",
                        childColumns = "user_id")
        }
)


public class Transaction {


    @ColumnInfo(name = "trans_type")
    public String mType;

    @PrimaryKey(autoGenerate = true)
    public int transId;

    @ColumnInfo(name = "username")
    public String mUserName;

    @ColumnInfo(name = "trans_date")
    public Date mTransDate;




    public Transaction(String mType, int transId, Date mTransDate){
        this.mType=mType;
        this.transId=transId;
        this.mTransDate=mTransDate;
    }
}
