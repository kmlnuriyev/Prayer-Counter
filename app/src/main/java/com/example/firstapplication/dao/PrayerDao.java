package com.example.firstapplication.dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.firstapplication.model.Prayer;

@Dao
public interface PrayerDao {

    @Insert
    public void addPrayer(Prayer prayer);

//    @Query("select * from users")
//    public List<User> findAll();
}
