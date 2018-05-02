package edu.csumb.huhernandez.project2;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


@Database(entities = {Book.class, User.class, Reservation.class}, version = 10, exportSchema = false)
@TypeConverters({DateConverter.class})


public abstract class LibraryDB extends RoomDatabase{
    private static LibraryDB sLibraryDb;
    public abstract BookDao bookDao();
    public abstract ReservationDao reservationDao();
    public abstract UserDao userDao();

    private static final Object sLock = new Object();

    public static LibraryDB getInstance(Context context){
        if (sLibraryDb == null) {
            sLibraryDb = Room.databaseBuilder(context.getApplicationContext(),
                    LibraryDB.class, "talent_agency.db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return sLibraryDb;
    }

    public void populateInitialData() {

        if (bookDao().count() == 0) {

            beginTransaction();


            try{
                bookDao().addBook(new Book("Hot Java", "S Narayanan","123-ABC-101", 0.05, "y"));
                bookDao().addBook(new Book("Fun Java", "Y Byun","ABCDEF-09", 0.5, "y"));
                bookDao().addBook(new Book("Algorithm For Java", "K Alice","CDE-777-123", 0.5, "y"));

                setTransactionSuccessful();

            } finally {
                endTransaction();
            }
        }
        if (userDao().count()==0) {
            beginTransaction();
            try{
                userDao().addUser(new User("a@lice5","@csit100"));
                userDao().addUser(new User("$brian7","123abc##"));
                userDao().addUser(new User("!chris12!","CHRIS12!!"));
                setTransactionSuccessful();
            }finally{
                endTransaction();
            }
        }
    }



}
