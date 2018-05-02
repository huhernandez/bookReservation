package edu.csumb.huhernandez.project2;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ReservationDao {

    @Query("select count(*) from reservations")
    int count();

//    @Query("select * from reservations where date between :mPickupdate AND :mReturnDate")
//    List<Reservation>  ;


    //@Insert
    //long addEntertainer(Entertainer entertainer);
    @Insert
    long addReservation(Reservation reservation);


}
