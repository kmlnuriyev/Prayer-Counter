package com.example.firstapplication.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.firstapplication.dao.PrayerDao;
import com.example.firstapplication.dao.UserDao;
import com.example.firstapplication.model.Prayer;
import com.example.firstapplication.model.User;

@Database(entities = {User.class, Prayer.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract PrayerDao prayerDao();
}
