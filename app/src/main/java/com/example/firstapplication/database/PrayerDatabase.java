package com.example.firstapplication.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.firstapplication.dao.PrayerDao;
import com.example.firstapplication.dao.UserDao;
import com.example.firstapplication.model.Prayer;
import com.example.firstapplication.model.User;

@Database(entities = {Prayer.class}, version = 1)
public abstract class PrayerDatabase extends RoomDatabase {
    public abstract PrayerDao prayerDao();
}
