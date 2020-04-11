package com.example.firstapplication.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.firstapplication.model.Prayer;

import java.util.List;

@Dao
public interface PrayerDao {

    @Insert
    public void add(Prayer prayer);

    @Query("select * from prayer_info")
    public List<Prayer> findAll();

    @Update
    public void update(Prayer prayer);
}
