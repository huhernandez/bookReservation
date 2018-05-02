package edu.csumb.huhernandez.project2;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;
@Dao
public interface UserDao {

    @Query("select count(*) from users")
    int count();

//    @Query("select username from users where username =:un")
//    User usernameMatch(String un);

    @Insert
    long addUser(User user);


    @Query("select username from users")
    List<String> getAllUsernames();
}
